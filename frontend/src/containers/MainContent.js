import React from 'react';
import {BrowserRouter as Router, Route, Switch}  from 'react-router-dom';
import CreateMatch from './CreateMatch'
import CreateSeason from './CreateSeason'
import SeasonResults from './SeasonResults'

const MainContent = () => {
    return(
        <Switch>
            <Route path="/create_match" component={CreateMatch}/>
            <Route path="/create_season" component={CreateSeason}/>
            <Route path="/season_results" component={SeasonResults}/>


        
        </Switch>
    )
}

export default MainContent