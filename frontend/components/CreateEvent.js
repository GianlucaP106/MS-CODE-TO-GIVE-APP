import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import YardIcon from '@mui/icons-material/Yard';
import Typography from '@mui/material/Typography';
import {createTheme, ThemeProvider} from '@mui/material/styles';
import FormControl from "@mui/material/FormControl";
import InputLabel from "@mui/material/InputLabel";
import Select from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";
import OutlinedInput from '@mui/material/OutlinedInput';
import ListItemText from '@mui/material/ListItemText';
import Checkbox from '@mui/material/Checkbox';
import PrimarySearchAppBar from './Layout/PrimarySearchAppBar'

const theme = createTheme();

const ITEM_HEIGHT = 48;
const ITEM_PADDING_TOP = 8;
const MenuProps = {
  PaperProps: {
    style: {
      maxHeight: ITEM_HEIGHT * 4.5 + ITEM_PADDING_TOP,
      width: 250,
    },
  },
};

const names  = [
        'Alfalfa',
        'Lentils',
        'Peas',
        'Soybeans',
        'Wheat',
        'Corn',
        'Flax',
        'Linola',
        'Rye',
        'Sorghum',
        'Canary_Seed',
        'Canola',
        'Millet',
        'Mustard',
        'Barley',
        'Buckwheat',
        'Oats',
        'Sunflower',
        'Coriander',
        'Crested_Wheat_Grass',
        'Brome_Grass',
        'Apples',
        'Lima_Beans_Unshelled',
        'Pole_Beans',
        'Snap_Beans',
        'Shelled_Corn',
        'Corn_in_ear',
        'Cowpeas',
        'Cucumbers',
        'Eggplant',
        'English_Peas_In_Hull',
        'Muscadines',
        'Mustard_Greens',
        'Onions',
        'Peaches',
        'Field_Peas',
        'Sweet_Potatoes_Fresh',
        'Sweet_Potatoes_Dry',
        'Spinach',
        'Tomatoes',
        'Turnips',
        'Turnip_Greens_Dry',
        'Turnip_Greens_Wet',
        'Squash',
        'Cantaloupe', 
        'Grapes_With_Stem',
        'Pears',
        'Plums',
        'Wax_Beans',
        'White_Beans',
        'Beets',
        'Bran',
        'Carrots',
        'Cotton_Seed',
        'Cranberries',
        'Gooseberries',
        'Hickory_Nuts',
        'Lime',
        'Malt',
        'Parsnips',
        'Irish_Potatoes',
        'Rutabaga',
        'Spelt',
        'Walnuts'
]
export default function Create(props) {

    const [personName, setPersonName] = React.useState([]);

    const handleChange = (event) => {
      const {
        target: { value },
      } = event;
      setPersonName(
        // On autofill we get a stringified value.
        typeof value === 'string' ? value.split(',') : value,
      );
    };

    return (
        <div>
            <PrimarySearchAppBar />
            <ThemeProvider theme={theme}>
                <Grid container component="main" sx={{ height: '100vh' }}>
                    <CssBaseline />
                    <Grid
                        item
                        xs={false}
                        sm={4}
                        md={7}
                        sx={{
                            backgroundImage: 'url(https://www.greenqueen.com.hk/wp-content/uploads/2020/12/Veganic-Farming.png)',
                            backgroundRepeat: 'no-repeat',
                            backgroundColor: (t) =>
                                t.palette.mode === 'light' ? t.palette.grey[50] : t.palette.grey[900],
                            backgroundSize: 'cover',
                            backgroundPosition: 'center',
                        }}
                    />
                    <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
                        <Box
                            sx={{
                                my: 8,
                                mx: 4,
                                display: 'flex',
                                flexDirection: 'column',
                                alignItems: 'center',
                            }}
                        >
                            <Avatar sx={{ m: 1, bgcolor: 'green' }}>
                                <YardIcon />
                            </Avatar>
                            <Typography component="h1" variant="h5">
                                Create Event
                            </Typography>
                            <br>
                            </br>

                            <Box component="form" noValidate sx={{ mt: 1 }}>
                                <TextField
                                    margin="normal"
                                    required
                                    fullWidth
                                    id="Event Name"
                                    label="Event Name"
                                    name="Event Name"
                                    autoComplete="Event Name"
                                    autoFocus
                                />
                                <TextField
                                    margin="normal"
                                    required
                                    fullWidth
                                    name="Event Description"
                                    label="Event Description"
                                    type="Event Description"
                                    id="Event Description"
                                    autoComplete="Event Description"
                                />
                                <TextField
                                    margin="normal"
                                    required
                                    fullWidth
                                    name="Farm"
                                    label="Farm"
                                    type="Farm"
                                    id="Farm"
                                    autoComplete="Farm"
                                />
                                <Button
                                    type="submit"
                                    fullWidth
                                    variant="outlined"
                                    sx={{ mt: 3, mb: 2 }}
                                >
                                    Get Gleaning!
                                </Button>
                            </Box>

                            <FormControl sx={{ m: 1, width: 300 }}>
                                <InputLabel id="demo-multiple-checkbox-label">Produce</InputLabel>
                                <Select
                                labelId="demo-multiple-checkbox-label"
                                id="demo-multiple-checkbox"
                                multiple
                                value={personName}
                                onChange={handleChange}
                                input={<OutlinedInput label="Produce" />}
                                renderValue={(selected) => selected.join(', ')}
                                MenuProps={MenuProps}
                                >
                                {names.map((name) => (
                                    <MenuItem key={name} value={name}>
                                    <Checkbox checked={personName.indexOf(name) > -1} />
                                    <ListItemText primary={name} />
                                    </MenuItem>
                                ))}
                                </Select>
                            </FormControl>
                        </Box>
                    </Grid>
                </Grid>
            </ThemeProvider>
        </div>
    );
}