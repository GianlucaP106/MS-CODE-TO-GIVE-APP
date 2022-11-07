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


  let markers = [
    { lat: 45.5019, lng: -73.5674  },
    { lat: 47.5019, lng: -73.5674  },
    { lat: 45.5019, lng: -70.5674  },
    { lat: 39.5019, lng: -73.5674  },
    { lat: 45.5019, lng: -80.5674  }
  ]

  React.useEffect(() => {
    setEventsCoord(eventsCoord)
  }, [queryRes])

  React.useEffect(() => {
    navigator.geolocation
      .getCurrentPosition((geoLocation) => {
        setLocation({
          location: {
            lat: geoLocation.coords.latitude,
            lng: geoLocation.coords.longitude,
          }
        });
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