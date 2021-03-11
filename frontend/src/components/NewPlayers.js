import React, { useState } from "react";
import Request from "../helpers/Request";
import "./NewPlayers.css"


const NewPlayers = ({getAllPlayers}) => {

    const [statePlayer, setStatePlayer] = useState(
        {
            name: ""
        }
    )

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

    return(
        <>
        <h1>Manage Players</h1>
        <form onSubmit={createPlayer} class="new-player-form">
        <label>Player Name: </label>
        <input onChange={handlePlayerName} type="text" name="name" value={statePlayer.name}></input>
        <button type="submit" >Add Player</button>
        </form>
        </>
    )
}

export default NewPlayers