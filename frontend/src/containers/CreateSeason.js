import React, { useEffect, useState } from 'react';
import Request from '../helpers/Request';

const CreateSeason = ({seasons, incrementDataCounter}) => {


const [allPlayers, setAllPlayers] = useState([])

const [selectedPlayers, setSelectedPlayers] = useState([])

const [numberOfGames, setNumberOfGames] = useState(1)

const [seasonName, setSeasonName] = useState("Season name")



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

const selectedPlayersNodes = selectedPlayers.map((player) => {
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

const handleSeasonName = (event) => {
    setSeasonName(event.target.value)
}

const handleGameNumber = (event) => {
    setNumberOfGames(event.target.value)
}

const handleSubmitNewSeason = () => {
    const request = new Request();
    
    
    
    const submittedSeason = {
        name: seasonName,
        totalMatches: numberOfGames,
        players: selectedPlayers
    }
    if (submittedSeason.name !== "" && submittedSeason.totalMatches != 0 && submittedSeason.players.length !== 0) {
        request.post("api/seasons", submittedSeason)
        .then(() => setSeasonName(""))
        .then(() => setNumberOfGames(0))
        .then(() => setSelectedPlayers([])) 
        .then(() => incrementDataCounter())
        .then(() => getAllPlayers())
    }

}


if (selectedPlayers.length < 10){

    return(
        <>
        <h1>CreateSeason</h1>

        <form >
               
            <select name="select_players"   onChange={handleAddPlayerToTheList} >
                <option>Select 10 players from this list</option>
                {allPlayerNodes}
            </select>

           
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
            <button onClick={handleSubmitNewSeason} >Create New Season</button> 
            <label> Number of games: </label>
            <input type="number" required min="1" max="99" value={numberOfGames} name="numberOfGames" onChange={handleGameNumber}></input>
            <label> Season name: </label>

            <input type="text" required value={seasonName} name="seasonName" onChange={handleSeasonName}></input>
            <ul>
                {selectedPlayersNodes}
            </ul>
            </>
        )
}


export default CreateSeason;