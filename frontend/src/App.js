import React from 'react';
import './App.css';
import Header from './components/Header';
import Leaderboard from './components/Leaderboard';
import NavBar from './components/NavBar';
import MainContent from './containers/MainContent';

function App() {
  return (
    <>
      <Header title="Tournament App"/>
      <NavBar/>
      <Leaderboard/>
      <MainContent/>
    </>
  );
}

export default App;
