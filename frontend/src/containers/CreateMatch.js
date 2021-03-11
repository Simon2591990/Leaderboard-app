import React, { useEffect, useState } from 'react';
import {Link} from "react-router-dom"; 
import Request from '../helpers/Request';
import "./CreateMatch.css"



const CreateMatch = ({currentSeason, incrementDataCounter}) => {

    const createMatchUrl = "/api/seasons/" + currentSeason.id + "/new_match"
    const [match, setMatch] = useState(currentSeason.matches[currentSeason.matches.length -1]) 

    const [team1Score, setTeam1Score] = useState(0)
    const [team2Score, setTeam2Score] = useState(0)

    const handleTeeam1Score = (event) => {
        setTeam1Score(event.target.value)
    }
    const handleTeeam2Score = (event) => {
        setTeam2Score(event.target.value)
    }
    useEffect(() =>{
        incrementDataCounter()
    }, [])

    const createMatch = () => {
        let request = new Request();
        if (!match || match.gameNumber < currentSeason.totalMatches){
            if (!match || currentSeason.matches[currentSeason.matches.length-1].teams[0].result !== ""){
                request.get(createMatchUrl)
                .then(data => setMatch(data))
                .then(() => incrementDataCounter())
                setTeam1Score(0)
                setTeam2Score(0)
            }
        }
    }

    const submitScores = (event) => {
        event.preventDefault()

        let request = new Request();
        if (currentSeason.matches[currentSeason.matches.length-1].teams[0].result === ""){
            if (!match.gameNumber <= currentSeason.totalMatches){
                    const submitScoreUrl = `/api/matches/${match.id}/${team1Score}/${team2Score}`
                    request.put(submitScoreUrl)
                    .then(() => incrementDataCounter())
            }
        }
    }

   
        if (!match) {
            return(
                <>
                <div id="create-match-header">
                    <h1>Current Match</h1>
                    <button className="button" onClick={createMatch}>New {currentSeason.name} Match</button>
                    <button className="button" onClick={submitScores}>Submit Score</button>
                    </div>

                </>
            )
        }

        if (match) {
            const team1Nodes = match.teams[0].players.map((player, index) => {
                return(
                    <li key={player.id} >{player.name}</li>
                )
            })
            const team2Nodes = match.teams[1].players.map((player, index) => {
                return(
                    <li key={player.id} >{player.name}</li>
                )
            })

            return (
                <>
                <div className="create-match-container">
                    <div id="create-match-header">
                    <h1>Current Match</h1>
                    <button className="button" onClick={createMatch}>New {currentSeason.name} Match</button>
                    <button className="button" onClick={submitScores}>Submit Score</button>
                    
                    <h3 id="match-number">Match Number: {match.gameNumber} / {currentSeason.totalMatches}</h3>
                    </div>




                   <div className="match-container">
                         <div className="match-team team-2">
                             <h2>{match.teams[0].name} </h2>
                             <ul>
                                {team1Nodes}
                             </ul>
                            <div className="goals-input">
                                 <label>Goals: </label>
                                 <input onChange={handleTeeam1Score} type="number" min="0"  value={team1Score}></input>
                             </div>
                         </div>
                         <div className="match-team team-1">
                             <h2>{match.teams[1].name}</h2>
                             <ul>
                                 {team2Nodes}
                             </ul>
                             <div className="goals-input">
                                 <label>Goals: </label>
                                 <input onChange={handleTeeam2Score} type="number"  min="0" value={team2Score}></input>
                             </div>







                    {/* <div id="match-area">
                        <div className="teams" id="team1">
                        <h2>{match.teams[0].name} </h2>
                        <ul >
                            {team1Nodes}
                        </ul>
                        <div>
                        <label>Goals: </label>
                        <input onChange={handleTeeam1Score}  className="input" type="number" min="0"  value={team1Score}></input>
                        </div>
                        </div>
                        <div  className="teams">
                        <h2>{match.teams[1].name}</h2>
                        <ul>
                            {team2Nodes}
                            
                        </ul>
                        <div>
                        <label>Goals: </label>
                        <input onChange={handleTeeam2Score} type="number" className="input" min="0" value={team2Score}></input>
                        </div> */}




{/* // >>>>>>> feature/alert */}
                        </div>
                    </div>
                </div>
                </>
            )
        }
}

export default CreateMatch;


