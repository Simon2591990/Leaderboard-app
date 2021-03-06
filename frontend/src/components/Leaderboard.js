import React, { useEffect, useState } from 'react';
import Request from '../helpers/Request';

const Leaderboard = () => {

    const [players, setPlayers] = useState([]);

    
    const getPlayers = () => {
        const request = new Request();

        request.get("/api/players")
        .then(data => setPlayers(data))
    }
    
    useEffect(() => {
       getPlayers() 
    }, [])

    const playerNodes = players.map((player, index) => {
        return(
            <p>{player.name}</p>
        )
    })


    return(
        <>
        <h5>Leaderboard</h5>
        {playerNodes}
        </>
    )
}

export default Leaderboard;