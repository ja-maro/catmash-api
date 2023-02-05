import React from "react";
import { Link } from "react-router-dom";

const NavBar = () => {
    return (  
            <nav className="navbar">
                <div className="navbar-left">
                    <Link to="/" className="link">
                        <h2>Vote</h2>
                    </Link>
                    <Link to="/cats" className="link">
                        <h2>Cats</h2>
                    </Link>
                </div>
            </nav> 
    );
};

export default NavBar;
