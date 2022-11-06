import React from "react";
import bg from '../../public/greenbg.png'

export default function Hero(){
    return (
        <div className="p-5 text-center bg-light" styles={{backgroundImage: `url(${bg})`, marginTop: 58}}>
          <h1 className="mb-3">Heading</h1>
          <h4 className="mb-3">Subheading</h4>
          <a className="btn btn-primary" href="" role="button">Call to action</a>
        </div>
    )
}