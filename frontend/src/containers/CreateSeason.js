import React, { useEffect, useState } from 'react';
import Request from '../helpers/Request';

const CreateSeason = ({seasons}) => {


const [allPlayers, setAllPlayers] = useState([])

const [selectedPlayers, setSelectedPlayers] = useState([])

const getAllPlayers = () => {
    const reqest = new Request();
    reqest.get("/api/players")
    .then(data => setAllPlayers(data))
}

useEffect(() => {
    getAllPlayers() 
 }, [])

const allPlayerNodes = allPlayers.map((player, index) => {
    

    return( 
        
          <option key={player.id} value={player.id}>{player.name}</option>
        )  
})

const selectedPlayersNodes = selectedPlayers.map((player, index) => {
    return(
        <li>{player.name}</li>
    )
})

const handleAddPlayerToTheList = (event) => {
    event.preventDefault()
    setSelectedPlayers([...selectedPlayers,allPlayers[event.target.value]])
}

    return(
        <>
        <h1>CreateSeason</h1>

        <form onSubmit={handleAddPlayerToTheList}>
            <label>  Select 10 players from this list:  
            <select name="select_players"  value="Select 10 players from this list:  " onChange={handleAddPlayerToTheList}>
                {allPlayerNodes}
            </select>
            </label>
        </form>
        <ul>
            {selectedPlayersNodes}
        </ul>
        
        </>
    )
}


export default CreateSeason;