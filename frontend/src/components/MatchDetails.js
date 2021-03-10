import React from 'react';
import {
    Accordion,
    AccordionItem,
    AccordionItemHeading,
    AccordionItemButton,
    AccordionItemPanel,
} from 'react-accessible-accordion';

const MatchDetails = ({match}) => {
    const team1PlayerNodes = match.teams[0].players.map((player, index) => {
        return(
            <li key={player.id} >{player.name}</li>
        )
    })
    const team2PlayerNodes = match.teams[1].players.map((player, index) => {
        return(
            <li key={player.id} >{player.name}</li>
        )
    })



    return(
        <>
        


            <AccordionItem>
                <AccordionItemHeading>
                    <AccordionItemButton>
                    <div>
                        <h3>{match.teams[0].result}</h3>
                        <h2>{match.teams[0].name}</h2>
                        <h2>{match.teams[0].goals}</h2>
                        <h1>vs</h1>
                        <h2>{match.teams[1].goals}</h2>
                        <h2>{match.teams[1].name}</h2>
                        <h3>{match.teams[1].result}</h3>
                    </div>
                    </AccordionItemButton>
                </AccordionItemHeading>
                <AccordionItemPanel>
                    {team1PlayerNodes}
                    {team2PlayerNodes}
                </AccordionItemPanel>
            </AccordionItem>
        </>
    )
}

export default MatchDetails;