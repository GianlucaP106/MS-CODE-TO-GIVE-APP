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


const drawerWidth = 300;

const top100Films = [
  { title: "The Shawshank Redemption", year: 1994 },
  { title: "The Godfather", year: 1972 },
  { title: "The Godfather: Part II", year: 1974 },
  { title: "The Dark Knight", year: 2008 },
  { title: "12 Angry Men", year: 1957 },
  { title: "Schindler's List", year: 1993 },
  { title: "Pulp Fiction", year: 1994 },
  {
    title: "The Lord of the Rings: The Return of the King",
    year: 2003,
  },
  { title: "The Good, the Bad and the Ugly", year: 1966 },
  { title: "Fight Club", year: 1999 },
  {
    title: "The Lord of the Rings: The Fellowship of the Ring",
    year: 2001,
  },
  {
    title: "Star Wars: Episode V - The Empire Strikes Back",
    year: 1980,
  },
  { title: "Forrest Gump", year: 1994 },
  { title: "Inception", year: 2010 },
  {
    title: "The Lord of the Rings: The Two Towers",
    year: 2002,
  },
  { title: "One Flew Over the Cuckoo's Nest", year: 1975 },
  { title: "Goodfellas", year: 1990 },
  { title: "The Matrix", year: 1999 },
  { title: "Seven Samurai", year: 1954 },
  {
    title: "Star Wars: Episode IV - A New Hope",
    year: 1977,
  },
  { title: "City of God", year: 2002 },
  { title: "Se7en", year: 1995 },
  { title: "The Silence of the Lambs", year: 1991 },
  { title: "It's a Wonderful Life", year: 1946 },
  { title: "Life Is Beautiful", year: 1997 },
  { title: "The Usual Suspects", year: 1995 },
  { title: "Léon: The Professional", year: 1994 },
  { title: "Spirited Away", year: 2001 },
  { title: "Saving Private Ryan", year: 1998 },
  { title: "Once Upon a Time in the West", year: 1968 },
  { title: "American History X", year: 1998 },
  { title: "Interstellar", year: 2014 },
  { title: "Casablanca", year: 1942 },
  { title: "City Lights", year: 1931 },
  { title: "Psycho", year: 1960 },
  { title: "The Green Mile", year: 1999 },
  { title: "The Intouchables", year: 2011 },
  { title: "Modern Times", year: 1936 },
  { title: "Raiders of the Lost Ark", year: 1981 },
  { title: "Rear Window", year: 1954 },
  { title: "The Pianist", year: 2002 },
  { title: "The Departed", year: 2006 },
  { title: "Terminator 2: Judgment Day", year: 1991 },
  { title: "Back to the Future", year: 1985 },
  { title: "Whiplash", year: 2014 },
  { title: "Gladiator", year: 2000 },
  { title: "Memento", year: 2000 },
  { title: "The Prestige", year: 2006 },
  { title: "The Lion King", year: 1994 },
  { title: "Apocalypse Now", year: 1979 },
  { title: "Alien", year: 1979 },
  { title: "Sunset Boulevard", year: 1950 },
  {
    title:
      "Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb",
    year: 1964,
  },
  { title: "The Great Dictator", year: 1940 },
  { title: "Cinema Paradiso", year: 1988 },
  { title: "The Lives of Others", year: 2006 },
  { title: "Grave of the Fireflies", year: 1988 },
  { title: "Paths of Glory", year: 1957 },
  { title: "Django Unchained", year: 2012 },
  { title: "The Shining", year: 1980 },
  { title: "WALL·E", year: 2008 },
  { title: "American Beauty", year: 1999 },
  { title: "The Dark Knight Rises", year: 2012 },
  { title: "Princess Mononoke", year: 1997 },
  { title: "Aliens", year: 1986 },
  { title: "Oldboy", year: 2003 },
  { title: "Once Upon a Time in America", year: 1984 },
  { title: "Witness for the Prosecution", year: 1957 },
  { title: "Das Boot", year: 1981 },
  { title: "Citizen Kane", year: 1941 },
  { title: "North by Northwest", year: 1959 },
  { title: "Vertigo", year: 1958 },
  {
    title: "Star Wars: Episode VI - Return of the Jedi",
    year: 1983,
  },
  { title: "Reservoir Dogs", year: 1992 },
  { title: "Braveheart", year: 1995 },
  { title: "M", year: 1931 },
  { title: "Requiem for a Dream", year: 2000 },
  { title: "Amélie", year: 2001 },
  { title: "A Clockwork Orange", year: 1971 },
  { title: "Like Stars on Earth", year: 2007 },
  { title: "Taxi Driver", year: 1976 },
  { title: "Lawrence of Arabia", year: 1962 },
  { title: "Double Indemnity", year: 1944 },
  {
    title: "Eternal Sunshine of the Spotless Mind",
    year: 2004,
  },
  { title: "Amadeus", year: 1984 },
  { title: "To Kill a Mockingbird", year: 1962 },
  { title: "Toy Story 3", year: 2010 },
  { title: "Logan", year: 2017 },
  { title: "Full Metal Jacket", year: 1987 },
  { title: "Dangal", year: 2016 },
  { title: "The Sting", year: 1973 },
  { title: "2001: A Space Odyssey", year: 1968 },
  { title: "Singin' in the Rain", year: 1952 },
  { title: "Toy Story", year: 1995 },
  { title: "Bicycle Thieves", year: 1948 },
  { title: "The Kid", year: 1921 },
  { title: "Inglourious Basterds", year: 2009 },
  { title: "Snatch", year: 2000 },
  { title: "3 Idiots", year: 2009 },
  { title: "Monty Python and the Holy Grail", year: 1975 },
];

// get all events by radius  ---->
// {
//        get all events by crop type --- DONE
//        pair crop type search with radius -- TO BE COMPLETED 
//        get all events by farm name --- TO BE COMPLETED ****** important
//        get all events by event name -- TO BE COMPLETED ***** important
// }

// first get all farms within radius {farm get by filter}
// get all events
/*
        filter through all the events

            List : eventinradius
        for event in evenets
            if event.farmid is in farms 
                eventinradius.add(event)

            return event;
    */

export default function PermanentDrawerLeft(props) {
  const {setQueryRes, display} = props; 
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

    let incoming = null;
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

  const [textFieldInput, setTextFieldInput] = useState('');
  const [ event, setEvent ] = React.useState({});

  const [searchParameter, setSearchParameter] = React.useState("Event");
  const [searchDistance, setSearchDistance] = React.useState("");
  const [calling, setCalling] = useState(false);

  const keyDownHandler = (event) => {
    if (event.key === "Enter") {
      event.preventDefault();
      let queryResponse;

      if (searchParameter == "Crop") {
        queryResponse = getEventByCropTypeDataFromServer(textFieldInput);
        console.log(textFieldInput);
      }

      if (searchParameter == "Event") {
        queryResponse = getEventByNameFromServer(textFieldInput);
        console.log(textFieldInput);
      }

      // 👇️ call submit function here to display points on map
      if (queryResponse !== null) setQueryRes(queryResponse);
      console.log("Events Displayed On Map");
    }
  }

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

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    searchRez(
        data.get('query')
    );
};

  React.useEffect(() => {
    document.addEventListener("keypress", keyDownHandler);
  }, []);

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
          options={top100Films.map((event) => event.title)}
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
        <div>
            <h5>Event Selected</h5>
            <p>Event Name: {event.name}</p>
            <p>Description: {event.description}</p>
            <p>Producer: {event.producer}</p>
            <p>Date: {event.date}</p>
        </div>
      </Drawer>
    </Box>
  );
}
