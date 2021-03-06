import React, { useEffect, useState } from 'react';
import Request from '../helpers/Request';

const Leaderboard = () => {

    const [players, setPlayers] = useState([]);

    
    const getPlayers = () => {
        fetch("/api/players/")
        .then(res => res.json())
        .then(data => setPlayers(data))
    }
    // const getPlayers = function(){
    //     const request = new Request();
    //     const playersRequest = request.get("/api/players")
        
    //     Promise.all([playersRequest])
    //     .then((data) => {
    //         setPlayers(data[0])
    //     })
    // }


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