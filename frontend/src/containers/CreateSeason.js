import React from 'react';
import SeasonResults from './SeasonResults';

const CreateSeason = ({seasons}) => {

const playerNodes = seasons[0].players.map((player, index) => {
    return( 
          <option key={index} value={index}>{player.name}</option>
        )
       
    
})

    return(
        <>
        <h1>CreateSeason</h1>
        
        <select name="select_players" defaultValue="selected">
            <option  disabled value="selected">Select 10 Players</option>
            {playerNodes}
        </select>
         
         <button>Add player to the list</button>
        </>
    )
}


export default CreateSeason;