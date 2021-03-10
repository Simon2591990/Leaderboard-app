import React, { useEffect, useState } from 'react';
import './Leaderboard.css';
import Request from '../helpers/Request';

const Leaderboard = ({ allPlayers, players, currentSeasonName}) => {

    const [leaderboardSelected, setLeaderboardSelected] = useState("current")



    const assignMedal = (index) => {
        if (index === 0) {
            return <>&#129351;</>
        } else if (index === 1) {
            return <>&#129352;</>
        } else if (index === 2) {
            return <>&#129353;</>
        } else {
            return <></>
        }
    }
    const changeLeaderboard = (leaderboard) => {
        setLeaderboardSelected(leaderboard)
    }
        
    const playerNodes = players.map((player, index) => {
        return(
                <tr key={player.id}
                className="leaderboard-table-row">
                    <td>{index + 1}  {assignMedal(index)}</td>
                    <td>{player.name}</td>
                    <td>{player.gamesPlayed}</td>
                    <td>{player.gamesWon}</td>
                    <td>{player.gamesDrawn}</td>
                    <td>{player.gamesLost}</td>
                    <td>{player.points}</td>
                </tr>
        )
    })
    const allPlayerNodes = allPlayers.map((player, index) => {
        return(
                <tr key={player.id}
                className="leaderboard-table-row">
                    <td>{index + 1}  {assignMedal(index)}</td>
                    <td>{player.name}</td>
                    <td>{player.totalGamesPlayed}</td>
                    <td>{player.totalGamesWon}</td>
                    <td>{player.totalGamesDrawn}</td>
                    <td>{player.totalGamesLost}</td>
                    <td>{player.totalPoints}</td>
                </tr>
        )
        })
    

    if (leaderboardSelected === "current"){
        return(
            <>
            <h2>Leaderboard - {currentSeasonName}</h2>
            
            <button onClick={() => changeLeaderboard("all_time")}>Current Season</button>
            <table className="leaderboard-table">
                        <thead>
                            <tr className="leaderboard-table-header">
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
    if (leaderboardSelected === "all_time"){
        return(
            <>
            <h2>All Time Leaderboard</h2>
            <button onClick={() => changeLeaderboard("current")}>Current Season</button>
            <table className="leaderboard-table">
                        <thead>
                            <tr className="leaderboard-table-header">
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
                            {allPlayerNodes}
                        </tbody>
                    </table>
            </>
        )
    }
}

export default Leaderboard;