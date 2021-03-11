import React from 'react';
import {
    Accordion,
    AccordionItem,
    AccordionItemHeading,
    AccordionItemButton,
    AccordionItemPanel,
} from 'react-accessible-accordion';
import './MatchDetails.css';

const MatchDetails = ({match}) => {
    const team1PlayerNodes = match.teams[0].players.map((player, index) => {
        return(
            <p key={player.id} >{player.name}</p>
        )
    })
    const team2PlayerNodes = match.teams[1].players.map((player, index) => {
        return(
            <p key={player.id} >{player.name}</p>
        )
    })



    return(
        <>
        


            <AccordionItem>
                <AccordionItemHeading>
                    <AccordionItemButton>
                    <div className="match-result">
                        <h3 className="match-result-result">{match.teams[0].result}</h3>
                        <h2 className="match-result-name">{match.teams[0].name}</h2>
                        <h2 className="match-result-goals">{match.teams[0].goals}</h2>
                        <h1 className="match-result-vs">vs</h1>
                        <h2 className="match-result-goals">{match.teams[1].goals}</h2>
                        <h2 className="match-result-name">{match.teams[1].name}</h2>
                        <h3 className="match-result-result">{match.teams[1].result}</h3>
                    </div>
                    </AccordionItemButton>
                </AccordionItemHeading>
                <AccordionItemPanel>
                    <div className="accordion-teams">
                        <div className="team-players">
                            {team1PlayerNodes}
                        </div>
                        <div className="team-players">
                            {team2PlayerNodes}
                        </div>
                    </div>
                </AccordionItemPanel>
            </AccordionItem>
        </>
    )
}

export default MatchDetails;