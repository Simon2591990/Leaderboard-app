import React, { useState, useEffect } from "react";
import Request from "../helpers/Request"

const ManagePlayers = () => {

    const [statePlayer, setStatePlayer] = useState(
        {
            name: ""
        }
    )
    const [allPlayers, setAllPlayers] = useState([])

    const getAllPlayers = () => {
        const reqest = new Request();
        reqest.get("/api/players")
        .then(data => setAllPlayers(data))
    }
    
    useEffect(() => {
        getAllPlayers() 
     }, [])

    const handlePlayerName = (event) => {
        let propertyName = event.target.name;
        let copiedPlayer = {...statePlayer}
        copiedPlayer[propertyName] = event.target.value;
        setStatePlayer(copiedPlayer);
    }
    
    const createPlayer = (event) => {
        event.preventDefault()
        const request = new Request()
        request.post("api/players", statePlayer)
        .then(() => getAllPlayers())
        setStatePlayer({
            name: ""
        })
    }
    const deletePlayer = (player) => {
        const request = new Request();
        if (player.seasons.length === 0 || player.seasons[player.seasons.length -1].completed){
            request.delete(`api/players/${player.id}`)
            .then(() => getAllPlayers())
        }
        


    }

    const allPlayerNodes = allPlayers.map((player, index) => {  
        return( 
            <>
              
              <li  key={player.id}>
                <p>{player.name}</p>
                <button onClick={(() => deletePlayer(player))}>Delete</button>
              </li>
            </>
            )  
    })

    return(
        <>
        <h1>Create New Player Tab</h1>
        <form onSubmit={createPlayer}>
        <label>Player Name: </label>
        <input onChange={handlePlayerName} type="text" name="name" value={statePlayer.name}></input>
        <button type="submit" >Add Player</button>
        </form>
        <ul>
        {allPlayerNodes}
        </ul>
        </>
    )
}

export default ManagePlayers