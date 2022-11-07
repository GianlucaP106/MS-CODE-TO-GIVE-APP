import React from "react";
import { GoogleMap, LoadScript, MarkerF, Bounds } from "@react-google-maps/api";

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
    const mapRef = React.useRef(null)

    const {size} = props;
    const [location, setLocation] = React.useState(center);
    const [zoom, setZoom] = React.useState(10);

    React.useEffect(()=>{
        navigator.geolocation.getCurrentPosition((geoLocation) => {
            setLocation({
              location: {
                lat: geoLocation.coords.latitude,
                lng: geoLocation.coords.longitude,
              },
            });
          }
        );

    }, [])


    let markers = [
      { lat: 45.5019, lng: -73.5674  },
      { lat: 47.5019, lng: -73.5674  },
      { lat: 45.5019, lng: -70.5674  },
      { lat: 39.5019, lng: -73.5674  },
      { lat: 45.5019, lng: -80.5674  }
    ]


    let bounds = mapRef.current.state.LatLngBounds()

    for (var i = 0; i < markers.length; i++) {
      bounds.extend(marker[i])
    }

    mapRef.current.fitBounds(bounds);

    return(
        <LoadScript googleMapsApiKey={process.env.NEXT_PUBLIC_GMAPS_KEY}>
            <GoogleMap
            mapContainerStyle={size}
            center={location}
            zoom={zoom}
            ref={mapRef}
            >
            {markers && markers.map((location) => {
                return (
                <MarkerF position={location} />
                )
            })}
            </GoogleMap>
        </LoadScript>
    )
}