import React from "react";
import bg from '../../public/greenbg.png'

export default function Hero(props){
    const {heading, subHeading} = props
    return (<div id="intro-example" className="p-5 text-center bg-image"
      style={{backgroundImage: `url(${"/greenbg.png"})`}}>
      <div className="mask" >
        <div className="d-flex justify-content-left align-items-center h-100" 
          style={{paddingLeft: "20rem"}}>
          <div className="text-black" style={{textAlign: "left"}}>
            <h1 className="mb-3 " style={{fontSize: "5rem", fontFamily: "Brush Script"}}><b>GLEAN</b> THE EARTH</h1>
            <h1 className="mb-3" style={{fontSize: "5rem", fontFamily: "Brush Script"}}>TO <b>CLEAN</b> EARTH</h1>
            <h5 className="mb-4" style={{fontSize: "2rem", paddingLeft: "2rem"}}>
              Helping farms all around the world 
            </h5>
            <h5 className="mb-4" style={{fontSize: "2rem", paddingLeft: "2rem"}}>
              to cultivate the most out of Earth.
            </h5>
            <a className="btn btn-outline-dark btn-lg m-3" style={{color: "black"}} href="https://www.calculator.net/gdp-calculator.html"
              role="button" rel="nofollow" target="_blank">Start Gleaning</a>
          </div>
        </div>
      </div>
    </div>)
}