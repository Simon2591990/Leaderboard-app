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
          <option  value={index}>{player.name}</option>
        )  
})

const selectedPlayersNodes = selectedPlayers.map((player, index) => {
    return(
        <li>{player.name}</li>
    )
})

const handleAddPlayerToTheList = (event) => {
    event.preventDefault()
    //add selected player to selectedPlayers state
    setSelectedPlayers([...selectedPlayers,allPlayers[event.target.value]])
    //remove selected player from allPlayers state
    const newAllPlayers = allPlayers.filter(function(player){
        return player.id !== (allPlayers[event.target.value].id)
    })
    setAllPlayers(newAllPlayers)
}


if (selectedPlayers.length < 10){

    return(
        <>
        <h1>CreateSeason</h1>

        <form onSubmit={handleAddPlayerToTheList}>
            <label>  List of registered players: 
               
            <select name="select_players"  value=" " onChange={handleAddPlayerToTheList}>
                <option>Select 10 players from this list</option>
                {allPlayerNodes}
            </select>
            </label>
        </form>
        
        <ul>
            {selectedPlayersNodes}
        </ul>
        </>
    )
    } else
        return(
            <>
            <h1>CreateSeason</h1>
            <button>Create New Season</button>
            <ul>
                {selectedPlayersNodes}
            </ul>
            </>
        )
}


export default CreateSeason;