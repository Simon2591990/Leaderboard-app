import React, { useState } from "react";
import Request from "../helpers/Request"

const NewPlayers = () => {

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
        setStatePlayer({
            name: ""
        })
    }

    return(
        <>
        <h1>Create New Player Tab</h1>
        <form onSubmit={createPlayer}>
        <label>Player Name: </label>
        <input onChange={handlePlayerName} type="text" name="name" value={statePlayer.name}></input>
        <button type="submit" >Add Player</button>
        </form>
        </>
    )
}

export default NewPlayers