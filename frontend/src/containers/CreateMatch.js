import React, { useState } from 'react';
import {Link} from "react-router-dom"; 
import Request from '../helpers/Request';

const CreateMatch = ({currentSeason}) => {

    const createMatchUrl = "/api/seasons/" + currentSeason.id + "/new_match"
    const [match, setMatch] = useState(currentSeason.matches[currentSeason.matches.length -1]) 

    const createMatch = () => {
        let request = new Request();

        request.get(createMatchUrl)
        .then(data => setMatch(data))
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
        {/* <h3>Match Number: {match.gameNumber}</h3> */}
        <div>
            <h2>{match.teams[0].name}</h2>
            <ul>
                {team1Nodes}
            </ul>
            <h2>{match.teams[1].name}</h2>
            <ul>
                {team2Nodes}
            </ul>
        </div>
        </>

    )
}

export default CreateMatch;



// /api/matches/{id}/{team1Score}/{team2Score}


