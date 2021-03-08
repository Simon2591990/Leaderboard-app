import React, { useState } from 'react';
import {Link} from "react-router-dom"; 
import Request from '../helpers/Request';

const CreateMatch = ({currentSeason}) => {

    const createMatchUrl = "/api/seasons/" + currentSeason.id + "/new_match"
    const [match, setMatch] = useState(currentSeason.matches[currentSeason.matches.length -1]) 

    const [team1Score, setTeam1Score] = useState(0)
    const [team2Score, setTeam2Score] = useState(0)
    const [scoreSubmitted, setScoreSubmitted] = useState(false)

    const handleTeeam1Score = (event) => {
        setTeam1Score(event.target.value)
    }
    const handleTeeam2Score = (event) => {
        setTeam2Score(event.target.value)
    }

    const createMatch = () => {
        let request = new Request();
        if (match.gameNumber < currentSeason.totalMatches){
        if (scoreSubmitted === true){
        request.get(createMatchUrl)
        .then(data => setMatch(data))

        setTeam1Score(0)
        setTeam2Score(0)
        setScoreSubmitted(false)
        }
    }
    }

    const submitScores = (event) => {
        event.preventDefault()
        let request = new Request();
        if (scoreSubmitted === false){
            const submitScoreUrl = `/api/matches/${match.id}/${team1Score}/${team2Score}`
            request.put(submitScoreUrl)
            setScoreSubmitted(true)
        }

    }

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

    
        return(
            <>
        <h1>Current Match</h1>
            <button onClick={createMatch}>New {currentSeason.name} Match</button>
            <button onClick={submitScores}>Submit Score</button>
        <h3>Match Number: {match.gameNumber} / {currentSeason.totalMatches}</h3>
        <div>
            <h2>{match.teams[0].name} </h2>
            <ul>
                {team1Nodes}
            </ul>
            <label>Goals: </label>
            <input onChange={handleTeeam1Score} type="number" min="0"  value={team1Score}></input>
            <h2>{match.teams[1].name}</h2>
            <ul>
                {team2Nodes}
            </ul>
            <label>Goals: </label>
            <input onChange={handleTeeam2Score} type="number"  min="0" value={team2Score}></input>
        </div>
        
        </>

    )
}

export default CreateMatch;


