import React from 'react';
import {Link} from 'react-router-dom' 


const NavBar = () => {
    return(
        <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/create_match">Create Match</Link>
            </li>
            <li>
              <Link to="/create_season">Create Season</Link>
            </li>
            <li>
              <Link to="/season_results">Season Results</Link>
            </li>
            <li>
              <Link to="/players">Manage Players</Link>
            </li>
        </ul>
    )
}


export default NavBar;