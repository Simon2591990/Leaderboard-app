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

    
        return(
            <>
        <h1>Current Match</h1>
        {/* <h3>Match Number: {match.gameNumber}</h3> */}
            <button onClick={createMatch}>New {currentSeason.name} Match</button>
        </>

    )
}


export default CreateMatch;

