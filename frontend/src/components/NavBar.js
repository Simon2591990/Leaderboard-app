import React from 'react';
import {Link} from 'react-router-dom' 
import './NavBar.css'

const NavBar = () => {
    return(
        <ul id="navbar-links-ul">
            <li className="nav-link">
              <Link to="/">Home</Link>
            </li>
            <li className="nav-link">
              <Link to="/players">Manage Players</Link>
            </li>
            <li className="nav-link">
              <Link to="/create_match">Create Match</Link>
            </li>
            <li className="nav-link">
              <Link to="/create_season">Create Season</Link>
            </li>
            <li className="nav-link">
              <Link to="/season_results">Season Results</Link>
            </li>
        </ul>
    )
}


export default NavBar;