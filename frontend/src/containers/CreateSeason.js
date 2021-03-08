import React, { useEffect, useState } from 'react';
import Request from '../helpers/Request';

const CreateSeason = ({seasons}) => {


const [allPlayers, setAllPlayers] = useState([])

const getAllPlayers = () => {
    const reqest = new Request();
    reqest.get("/api/players")
    .then(data => setAllPlayers(data))
}

useEffect(() => {
    getAllPlayers() 
 }, [])

const playerNodes = allPlayers.map((player, index) => {
    return( 
          <option key={index} value={index}>{player.name}</option>
        )  
})

    return(
        <>
        <h1>CreateSeason</h1>
        
        <select name="select_players" defaultValue="">
            <option  disabled value="">Select 10 Players</option>
            {playerNodes}
        </select>
        <button>Add player to the list</button>
        </>
    )
}


export default CreateSeason;