import React, { Component } from "react";
import { GoogleMap, LoadScript, Marker, Circle } from "@react-google-maps/api";

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
  clickable: false,
  draggable: false,
  editable: false,
  visible: true,
  radius: 30000,
  zIndex: 1,
};

class Map extends Component {
  state = {
    location: center,
    circleOptions: options,
  };

  componentDidMount() {
    navigator.geolocation.getCurrentPosition((geoLocation) => {
      this.setState({
        location: {
          lat: geoLocation.coords.latitude,
          lng: geoLocation.coords.longitude,
        },
      });
    });
  }

  render() {
    return (
      <LoadScript googleMapsApiKey="">
        <GoogleMap
          mapContainerStyle={this.props.size}
          center={this.state.location}
          zoom={10}
        >
          <Marker position={this.state.location} />
          <Circle position={this.state.location} options={options} />
        </GoogleMap>
      </LoadScript>
    );
  }
}

export default Map;
