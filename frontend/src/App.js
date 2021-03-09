import React, { useEffect, useState } from 'react';
import './App.css';
import Header from './components/Header';
import Leaderboard from './components/Leaderboard';
import NavBar from './components/NavBar';
import MainContent from './containers/MainContent';
import {BrowserRouter as Router}  from 'react-router-dom';
import Request from './helpers/Request';


function App() {

  const [seasons, setSeasons] = useState([]);

  const [players, setPlayers] = useState([]);

  const [currentSeason, setCurrentSeason] = useState([])

  const [isLoaded, setIsLoaded] = useState(false)
  const [newDataCounter, setNewDataCounter] = useState(0)

    
    const getSeasons = () => {
        const request = new Request();

        request.get("/api/seasons")
        .then(data => {
          setSeasons(data)
          setPlayers(data[data.length -1].players)
          setCurrentSeason(data[data.length -1])
          
        })
        .then(() => setIsLoaded(true))

        console.log("data fetched")
    }
    
    useEffect(() => {
       getSeasons() 
    }, [newDataCounter])

    useEffect(() => {
      sortPlayersByPoints()
    }, [players, newDataCounter])

    const incrementDataCounter = () => {
      setNewDataCounter(newDataCounter + 1)
    }

    const sortPlayersByPoints = () => {
      players.sort((player1, player2) => {
        return player2.points - player1.points;
      })
    }

  

  if (isLoaded === false){
    return(
      <p>Loading</p>
    )
  }

  return (
    <Router>
      <>
      <div id="header">
        <Header title="Tournament App"/>
      </div>
      <div id="nav-bar">
        <NavBar/>
      </div>
      <div id="leaderboard">
        <Leaderboard
        players={players}
        currentSeasonName={currentSeason.name}
        />
      </div>
      <div id="main-content">
        <MainContent seasons={seasons} currentSeason={currentSeason} incrementDataCounter={incrementDataCounter}/>
      </div>
      </>
    </Router>
    
  );
}

export default App;
