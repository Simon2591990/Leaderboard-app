import React from 'react';
import { Route, Switch }  from 'react-router-dom';
import CreateMatch from './CreateMatch'
import CreateSeason from './CreateSeason'
import SeasonResults from './SeasonResults'
import Home from '../components/Home'

const MainContent = ({seasons, currentSeason}) => {
    return(
        <Switch>
            <Route exact path="/" component={Home}/>
            <Route
                path="/create_match"
                render={() => <CreateMatch currentSeason={currentSeason}/>} 
                />
            <Route path="/create_season" component={CreateSeason}/>
            <Route path="/season_results" component={SeasonResults}/>
        </Switch>
    )
}

export default MainContent