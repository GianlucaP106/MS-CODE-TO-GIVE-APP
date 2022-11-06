import React from "react"

export default function HomepageCard(props){

  const {imgSrc, buttonLink, title, cardText } = props;

  return (
    <div className="card text-center border border-primary shadow-0 " style={{ backgroundColor:	"white", marginTop: 10, margin: 'auto', maxWidth: 350, height: 'auto'}}>
      <div style={{ zIndex: 5}} className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
        <img src={imgSrc} className="img-fluid" />
        <div className="mask" ></div>
      </div>

      <div className="card-body">
        <h5 className="card-title">{title}</h5>
        <p className="card-text">
          {cardText}
        </p>
        <a href={buttonLink}><button type="button" className="btn btn-primary">Button</button></a>
      </div>
    </div>
  )
}