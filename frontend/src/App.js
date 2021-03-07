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

    
    const getSeasons = () => {
        const request = new Request();

        request.get("/api/seasons")
        .then(data => {
          setSeasons(data)
          setPlayers(data[data.length -1].players)
        })
    }
    
    useEffect(() => {
       getSeasons() 
    }, [])


  return (
    <Router>
      <>
      <Header title="Tournament App"/>
      <NavBar/>
      <Leaderboard players={players}/>
      <MainContent/>
    </>
    </Router>
    
  );
}

export default App;
