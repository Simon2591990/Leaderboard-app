import React from 'react';
import { Route, Switch }  from 'react-router-dom';
import CreateMatch from './CreateMatch'
import CreateSeason from './CreateSeason'
import SeasonResults from './SeasonResults'
import Home from '../components/Home'
import NewPlayers from '../components/NewPlayers'

const MainContent = ({seasons, currentSeason, incrementDataCounter}) => {
        return(
            <Switch>
                <Route exact path="/" component={Home}/>
                <Route
                    path="/create_match"
                    render={() => <CreateMatch currentSeason={currentSeason} incrementDataCounter={incrementDataCounter}/>} 
                    />
                <Route 
                    path="/create_season" 
                    render={() => <CreateSeason currentSeason={currentSeason} incrementDataCounter={incrementDataCounter}/>} 
                    />
                <Route path="/season_results" component={SeasonResults}/>
                <Route path="/add_players" component={NewPlayers}/>
                
            </Switch>
        )
}

export default MainContent