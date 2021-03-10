import React, { useState } from 'react';
import MatchDetails from "../components/MatchDetails"

const SeasonResults = ({seasons}) => {

    const [selectedSeason, setSelectedSeason] = useState(seasons[seasons.length -1])

    const matchNodes = selectedSeason.matches.map((match)=> {
            return(
                <MatchDetails match={match} key={match.id}/>
            )
    })

    return(
        <>
            <h1>Season Results</h1>
            <p>{matchNodes}</p>
        </>

    )
}


export default SeasonResults;