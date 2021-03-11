import React, { useEffect, useState } from 'react';
import Request from '../helpers/Request';
import './Style.css'

const CreateSeason = ({currentSeason, incrementDataCounter}) => {


const [allPlayers, setAllPlayers] = useState([])

const [selectedPlayers, setSelectedPlayers] = useState([])

const [numberOfGames, setNumberOfGames] = useState(0)

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
        <>
          <li><button className="button" onClick={() => {handleAddPlayerToTheList(player)}} key={player.id}>+ {player.name}</button></li>
       </>
    )})

const selectedPlayersNodes = selectedPlayers.map((player) => {
    return(
        <li><button className="button" onClick={() => {removePlayerFromTheList(player)}} key={player.id}>- {player.name}</button></li>
    )
})

const handleAddPlayerToTheList = (player) => {
    //add selected player to selectedPlayers state
    setSelectedPlayers([...selectedPlayers, player])
    //remove selected player from allPlayers state
    const newAllPlayers = allPlayers.filter(function(playerInAllPlayers){
        return player.id !== (playerInAllPlayers.id)
    })
    setAllPlayers(newAllPlayers)
}
const removePlayerFromTheList = (player) => {

    setAllPlayers([...allPlayers, player])

    const newSelectedPlayers = selectedPlayers.filter(function(playerinSelectedPlayers){
        return player.id !== (playerinSelectedPlayers.id)
    })
    setSelectedPlayers(newSelectedPlayers)
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
        .then(() => {window.location = '/create_match/'})
    }

}
if (currentSeason.matches.length < currentSeason.totalMatches){
    return(
        <>
        <div id="create-season-header">
        <h1>Create Season</h1>
        <h3>Finish the current season first</h3>
        </div>
        </>
    )
}
else {

if (selectedPlayers.length < 10){

    return(
        <>

        <h1 id="create-season-header">Create Season</h1>
                    
        <div id="createLists">
            <div>
            <p>All players:</p>
            
            <ul>
                {allPlayerNodes}
            </ul>
            </div>
            <div>
            <p>10 players to start new season:</p>
            
            <ul>
                {selectedPlayersNodes}
            </ul>
            </div>
        </div>
        </>
    )
    } else
        return(
            <>
            <div id="create-season-header">
            <h1>Create Season</h1>
        
            
            <label> Number of games: </label>
            <input type="number" required min="1" max="99" value={numberOfGames} name="numberOfGames" onChange={handleGameNumber}></input>
            <label> Season name: </label>

            <input type="text" className="input" id="season-name-input" value={seasonName} name="seasonName" onChange={handleSeasonName}></input>
            <button className="button"  onClick={handleSubmitNewSeason} >Create New Season</button>
            </div>
            <div id="create-season-header">
            <ul id="players-list-in-create-season">
                {selectedPlayersNodes}
            </ul>
            </div>
            </>
        )
}
}


export default CreateSeason;