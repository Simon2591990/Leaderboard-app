import React from "react"
import football from '../assets/football.gif'
import logo from '../assets/logo.png'

const Header = ({title}) => {
    return(
        <>
        
        <img src={football} height="80"/>
        <img src={logo} height="80"/>
        <img src={football} height="80"/>
        </>
    )
}

export default Header