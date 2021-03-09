import React, { useEffect, useState } from 'react';
import Request from '../helpers/Request';

const CreateSeason = ({seasons}) => {


const [allPlayers, setAllPlayers] = useState([])

const [selectedPlayers, setSelectedPlayers] = useState([])

const [numberOfGames, setNumberOfGames] = useState(1)

const [seasonName, setSeasonName] = useState("Season name")

const [newSeason, setNewSeason] = useState({
    name: "",
    totalMatches: 0,
    players: []
})

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
    
    selectedPlayers.forEach(player => {
        player.gamesPlayer = 0;
        player.gamesWon = 0;
        player.gamesLost = 0;
        player.gamesDrawn = 0;
        player.points = 0;
        request.put(`api/players/${player.id}`, player)
        
    });
    
    setNewSeason({
        name: seasonName,
        totalMatches: numberOfGames,
        players: selectedPlayers
    })
    if (newSeason.name !== "" && newSeason.totalMatches != 0 && newSeason.players.length !== 0) {
        request.post("api/seasons", newSeason)
        
        
        setNewSeason({
            name: "",
            totalMatches: 0,
            players: []
        })
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