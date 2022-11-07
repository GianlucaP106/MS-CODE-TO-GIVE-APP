import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Collapse from "react-bootstrap/Collapse";
import Link from "next/link";
import styles from '../styles/components/Navibar.module.css'

import { useState, useEffect } from "react";

export default function Navibar() {

    const [open, setOpen] = useState(false);
    const [burger, setBurger] = useState(false);

    return(
        <div className={`${styles.wrapper} myNavbar`} id="">
            <Navbar fixed="top" collapseOnSelect expand="lg" className="" variant="dark" >
                <Container>
                    <Navbar.Brand href="/"><img src="/assets/logos/devproLogo.png" className="" alt="" height="60" /></Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="me-auto ms-auto">
                            <Nav.Link className="text-black" href="/">Home</Nav.Link>
                            <Collapse in={open} id="collapseMobile">
                                <div className="collapseTextMobile" id="example-collapse-text">
                                    <Nav.Link className="" href="">Web Development</Nav.Link>
                                    <Nav.Link className="" href="">Graphic Design</Nav.Link>
                                    <Nav.Link className="" href="">Marketing</Nav.Link>
                                </div>
                            </Collapse>

                            <Nav.Link className="text-black" href="" > Experience</Nav.Link>
                            <Nav.Link className="text-black" href="" > Skills</Nav.Link>
                        </Nav>
                        <Nav>
                            <Nav.Link href=""><button className=""><p style={{margin: "0"}} className="">Sign in</p></button></Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>

    );
}