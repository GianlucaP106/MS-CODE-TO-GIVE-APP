import React, {useState, useEffect, useRef} from "react";
import Drawer from "@mui/material/Drawer";
import CssBaseline from "@mui/material/CssBaseline";
import Divider from "@mui/material/Divider";
import TextField from "@mui/material/TextField";
import Autocomplete from "@mui/material/Autocomplete";
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import FormControl from "@mui/material/FormControl";
import FormLabel from "@mui/material/FormLabel";
import styles from "../styles/components/Drawer.module.css";
import Input from "@mui/material/Input";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import SearchIcon from '@mui/icons-material/Search';
import * as _ from 'lodash';

const drawerWidth = 300;

export default function PermanentDrawerLeft(props) {
  const {setQueryRes, display} = props; 
  const [ allEvents, setAllEvents ] = useState([]);

  async function getEventByCropTypeDataFromServer(data) {
    let response = null;
    try {
      response = await fetch(`http://localhost:8080/produce/get-event`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: data
      });
      response = await response.json();
    } catch (e) {
      console.log(e);
    }

    if (response) {
      console.log(response)
      return response
    } else return null;
  }

  async function getEventByNameFromServer(data) {
    let response = null;
    let out = {
      name : data
    }

    try {
      response = await fetch(`http://localhost:8080/event/get-by-filter`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(out)
      });
      response = await response.json();
    } catch (e) {
      console.log(e);
    }

    if (response) {
      console.log(response)
      return response
    } else return null;
  }


  useEffect(() => {
    getEventsFromServer()
  }, [])

  const [textFieldInput, setTextFieldInput] = useState('');
  const [ event, setEvent ] = React.useState({});

  const [searchParameter, setSearchParameter] = React.useState("Event");
  const [searchDistance, setSearchDistance] = React.useState("");

  const searchRez = (data) => {
    let queryResponse;

      if (searchParameter == "Crop") {
        queryResponse = getEventByCropTypeDataFromServer(data);
        console.log(data);
      }

      if (searchParameter == "Event") {
        queryResponse = getEventByNameFromServer(data);
        console.log(data);
      }

      // 👇️ call submit function here to display points on map
      if (queryResponse !== null) setQueryRes(queryResponse);
      console.log("Events Displayed On Map");
  }

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
    
    marks = _.uniqWith(marks, (event, otherEvent) => {
      return _.isEqual(event.name, otherEvent.name);
    });

    setAllEvents(marks);
    console.log(marks)
  } 

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    searchRez(
        data.get('query')
    );
};

  React.useEffect(() => {
    setEvent(display);
  }, [display]);

  const handleTextValueChange = () => {
    console.log("Were are here")
    console.log(document.getElementById("inputField"))
    // searchRez(inputRef.current.value)
  }

  const handleTextValueChangeR = (e) => {
    setTextFieldInput(e.target.value);
    // searchRez(inputRef.current.value)
  }

  return (
    <Box sx={{ display: "flex" }}>
      <CssBaseline />
      <Drawer
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          "& .MuiDrawer-paper": {
            width: drawerWidth,
            boxSizing: "border-box",
          },
        }}
        variant="permanent"
        anchor="left"
      >
        <Autocomplete
          freeSolo
          id="free-solo-2-demo"
          disableClearable
          options={allEvents.map((event) => event.name)}
          className={styles.searchField}
          renderInput={(params) => (
            <Box component="form" noValidate onSubmit={handleSubmit}>
              <TextField
              {...params}
              margin="normal"
              required
              fullWidth
              name="query"
              autoFocus
              id="inputField"
              label="Search input"
              InputProps={{
                ...params.InputProps,
                type: "search"
              }}
              />
              <Button type="submit"
                fullWidth
                variant="outlined"
                sx={{ mt: 3, mb: 2 }}><SearchIcon /></Button>
            </Box>
              
          )}
        />            
        {/* <button onClick={handleTextValueChange}>Log message</button> */}

        <FormControl className={styles.formControl}>
          <FormLabel id="searchType-demo-radio-buttons-group-label">
            Search By:
          </FormLabel>
          <RadioGroup
            aria-labelledby="searchType-demo-radio-buttons-group-label"
            name="searchType-radio-buttons-group"
            row
            onChange={(e) => setSearchParameter(e.target.value)}
          >
            <FormControlLabel
              value="Event"
              control={<Radio />}
              label="Event"
              //onClick={console.log("clicked")}
            />
            <FormControlLabel value="Farm" control={<Radio />} label="Farm" />
            <FormControlLabel value="Crop" control={<Radio />} label="Crop" />
          </RadioGroup>
        </FormControl>
        <FormControl className={styles.formControl}>
          <FormLabel id="demo-radio-buttons-group-label">Distance:</FormLabel>
          <RadioGroup
            aria-labelledby="demo-radio-buttons-group-label"
            name="radio-buttons-group"
            row
            onChange={(e) => setSearchDistance(e.target.value)}
          >
            <FormControlLabel value="50" control={<Radio />} label="50 km" />
            <FormControlLabel value="100" control={<Radio />} label="100 km" />
            <FormControlLabel
              value="100+"
              control={<Radio />}
              label="100+ km"
            />
          </RadioGroup>
        </FormControl>
        <Divider />
        <div className={`${styles.buttonWrapper} mt-3 mb-3`}>
            <a href='/CreateEvent'>
              <button className="btn btn-primary">
                !!! Create an event !!!
              </button>
            </a>
        </div>
        <div className={`${styles.eventInfo} text-center mt-5`}>
            <h5 className={`${styles.eventSelected}`}>Event Selected</h5>
            <p>
              <a href={(event.id) ? `/Event/${event.id}` : `/map`}>
                Event Name: {event.name}
              </a>
            </p>
            <p>Description: {event.description}</p>
            <p>Producer: {event.producer}</p>
            <p>Date: {event.date}</p>
        </div>
      </Drawer>
    </Box>
  );
}
