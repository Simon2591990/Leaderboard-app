import React, { useState } from 'react';
import MatchDetails from "../components/MatchDetails";
import {
    Accordion
} 
from 'react-accessible-accordion';
import "./SeasonResults.css"

const SeasonResults = ({seasons}) => {

    const [selectedSeason, setSelectedSeason] = useState(seasons[seasons.length -1])

    const matchNodes = selectedSeason.matches.map((match)=> {
            return(

                
                <MatchDetails match={match} key={match.id}/>
            )
    })

    return(
        <>
            <h1 id="season-results-header">Season Results</h1>
            <Accordion>
                {matchNodes}
            </Accordion>
        </>

    )
}


export default SeasonResults;