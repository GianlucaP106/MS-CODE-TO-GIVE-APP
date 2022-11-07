import React, { useState, useEffect } from "react";
import { GoogleMap, LoadScript, MarkerF, InfoWindow } from "@react-google-maps/api";
// import { withGoogleMap, withScriptjs } from "react-google-maps";

const center = {
  // Montreal
  lat: 45.5019,
  lng: -73.5674,
};

const options = {
  strokeColor: "#FF0000",
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: "#FF0000",
  fillOpacity: 0.35,
  clickable: true,
  draggable: false,
  editable: false,
  visible: true,
  radius: 30000,
  zIndex: 1
};

export default function Map(props){
  const {size, queryRes, setDisplay} = props;
  const [location, setLocation] = useState(center);
  const [zoom, setZoom] = useState(10);
  const [ eventsCoord, setEventsCoord ] = useState([]);


  let allEvents = [];

  // React.useEffect(() => {
  //   setEventsCoord(queryRes)
  // }, [queryRes])
  const fun = async (queryRes) => {
    let toDisplay = []

    let querried = await Promise.resolve(queryRes);
    if (querried && querried.event) {
      console.log(querried)
      console.log(eventsCoord)

      if (querried.event.length == 0) {
        getEventsFromServer()
        return
      }
      for (let event of eventsCoord) {
        for (let queryEvent of querried.event){
          if (queryEvent.ID === event.id){
            toDisplay.push(event)
          }
        }
      }

      console.log(toDisplay)

      setEventsCoord(toDisplay)
    }
    
  }

  React.useEffect(() => {
    fun(queryRes)
  }, [queryRes])

  React.useEffect(() => {
    navigator.geolocation
      .getCurrentPosition((geoLocation) => {
        setLocation(center);
          // location: {
          //   lat: geoLocation.coords.latitude,
          //   lng: geoLocation.coords.longitude,
          // }
    }); 
    getEventsFromServer();
  }, []);

  async function getEventsFromServer() {
    let events = null;
    try {
      events = await fetch("http://localhost:8080/event/all/withfarm");
      events = await events.json();
    }catch (e) {
      console.log(e);
    }      
    let marks = [];
    for (let event of events) {
      console.log(event);
      marks.push({
        loc: {
          lat: event.farm.latitude,
          lng: event.farm.longitude
        },
        id: event.id,
        name: event.eventName,
        description: event.description,
        date: event.date,
        farmName: event.farm.farmName,
        producer: `${event.farm.producer.firstName} ${event.farm.producer.lastName}`
      });
    }
    
    setEventsCoord(marks);
  } 
  function handleMarkerClick(eventData) {
    setDisplay(eventData)
  }
    
    return(
        <LoadScript googleMapsApiKey={process.env.NEXT_PUBLIC_GMAPS_KEY}>
            <GoogleMap
            mapContainerStyle={size}
            center={location}
            zoom={zoom}
            id={"google"}
            >
            {eventsCoord && eventsCoord.map((item) => {
              return (
                <MarkerF onClick={() => handleMarkerClick(item)} position={item.loc} />
                )
            })}
            </GoogleMap>
        </LoadScript>
    )
}