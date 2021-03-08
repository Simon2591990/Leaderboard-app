import React, { useEffect, useState } from 'react';
import Request from '../helpers/Request';

const Leaderboard = ({players}) => {

    const playerNodes = players.map((player, index) => {
        return(
            <p>{player.name}</p>
        )
    })


    return(
        <>
        <h2>Leaderboard</h2>
            {playerNodes}
        </>
    )
}

export default Leaderboard;