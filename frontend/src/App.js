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

    
    const getSeasons = () => {
        const request = new Request();

        request.get("/api/seasons")
        .then(data => {
          setSeasons(data)
          setPlayers(data[data.length -1].players)
          setCurrentSeason(data[data.length -1])
          
        })
        .then(() => setIsLoaded(true))
    }
    
    useEffect(() => {
       getSeasons() 
    }, [])

  

  if (isLoaded === false){
    return(
      <p>Loading</p>
    )
  }

  return (
    <Router>
      <>
      <Header  title="Tournament App"/>
      <NavBar/>
      <Leaderboard players={players}/>
      <MainContent seasons={seasons} currentSeason={currentSeason}/>
    </>
    </Router>
    
  );
}

export default App;
