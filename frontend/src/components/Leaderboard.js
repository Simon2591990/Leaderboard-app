import React, { useEffect, useState } from 'react';
import Request from '../helpers/Request';

const Leaderboard = ({players, currentSeasonName}) => {

    const playerNodes = players.map((player, index) => {
        return(
            <>
                <tr>
                    <td>{index + 1}</td>
                    <td>{player.name}</td>
                    <td>{player.gamesPlayed}</td>
                    <td>{player.gamesWon}</td>
                    <td>{player.gamesDrawn}</td>
                    <td>{player.gamesLost}</td>
                    <td>{player.points}</td>
                </tr>

            </>
        )
    })


    return(
        <>
        <h2>Leaderboard - {currentSeasonName}</h2>
        <table class="leaderboard-table">
                    <thead>
                        <tr>
                            <th>Postition</th>
                            <th>Player</th>
                            <th>Played</th>
                            <th>Won</th>
                            <th>Drawn</th>
                            <th>Lost</th>
                            <th>Points</th>
                        </tr>
                    </thead>
                    <tbody>
                        {playerNodes}
                    </tbody>
                </table>
        </>
    )
}

export default Leaderboard;