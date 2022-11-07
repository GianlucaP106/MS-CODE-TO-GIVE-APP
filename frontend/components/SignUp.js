import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import YardIcon from '@mui/icons-material/Yard';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import {MuiTelInput} from "mui-tel-input";
import {createTheme, ThemeProvider} from '@mui/material/styles';

const theme = createTheme();


export default function SignUp() {
    const handleSubmit = (event) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget);
        console.log({
            email: data.get('email'),
            password: data.get('password'),
            first_name: data.get('firstName'),
            last_name: data.get('lastName'),
            org_group_name: data.get('orgName'),
            description: data.get('Description'),
            missionStatement: data.get('Mission Statement'),
            phoneNumber: data.get('phone'),
            address: data.get('address'),
            postalCode: data.get('postal'),
            city: data.get('City'),
            username: data.get('username'),
            maxDistance: data.get('maxDistance'),
            websiteLink: data.get('websiteLink'),
            region: data.get('Region'),

        });
    }
    const [account, setAccount] = React.useState('');

    const [tel, setTel] = React.useState('CA');

    const handleTelChange = (newValue) => {
        setTel(newValue);
    };

    const handleChange = (event) => {
        setAccount(event.target.value);
        console.log(account)
        console.log(typeof account)
    };

    return (
        <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
                <CssBaseline />
                <Box
                    sx={{
                        marginTop: 8,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }}
                >
                    <Avatar sx={{ m: 1, bgcolor: 'green' }}>
                        <YardIcon />
                    </Avatar>
                    <Typography component="h1" variant="h5">
                        Sign up
                    </Typography>
                        <br>
                        </br>
                    <Box sx={{ minWidth: 120 }}>
                        <FormControl fullWidth>
                            <InputLabel id="demo-simple-select-label">Account Type</InputLabel>
                            <Select
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={account}
                                label="Account Type"
                                onChange={handleChange}
                            >
                                <MenuItem value={"Producer"}>Producer</MenuItem>
                                <MenuItem value={"Gleaner"}>Gleaner</MenuItem>
                                <MenuItem value={"Organization"}>Organization</MenuItem>
                                <MenuItem value={"Gleaning Group"}>Gleaning Group</MenuItem>
                            </Select>
                        </FormControl>
                    </Box>
                    <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
                        <Grid container spacing={2} hidden={account === ''}>
                            <Grid item xs={12} hidden={account === "Producer" || account === "Gleaner"}>
                                <TextField
                                    autoComplete="given-name"
                                    name="orgName"
                                    required
                                    fullWidth
                                    id="orgName"
                                    label="Name"
                                    autoFocus
                                />
                            </Grid>
                            <Grid item xs={12} hidden={account === "Producer" || account === "Gleaner"}>
                                <TextField
                                    autoComplete="description"
                                    name="Description"
                                    required
                                    fullWidth
                                    id="Description"
                                    label="Description"
                                    autoFocus
                                    multiline={true}
                                    minRows={1}
                                    maxRows={200}
                                />
                            </Grid>
                            <Grid item xs={12} hidden={account === "Producer" || account === "Gleaner"}>
                                <TextField
                                    autoComplete="missionStatement"
                                    name="Mission Statement"
                                    required
                                    fullWidth
                                    id="MissionStatement"
                                    label="Mission Statement"
                                    autoFocus
                                    multiline={true}
                                    minRows={1}
                                    maxRows={200}
                                />
                            </Grid>
                            <Grid item xs={12} sm={6} hidden={account === "Gleaner Group" || account === "Organization"}>
                                <TextField
                                    autoComplete="given-name"
                                    name="firstName"
                                    required
                                    fullWidth
                                    id="firstName"
                                    label="First Name"
                                    autoFocus
                                />
                            </Grid>
                            <Grid item xs={12} sm={6} hidden={account === "Gleaner Group" || account === "Organization"}>
                                <TextField
                                    required
                                    fullWidth
                                    id="lastName"
                                    label="Last Name"
                                    name="lastName"
                                    autoComplete="family-name"
                                />
                            </Grid>
                            <Grid item xs={12} hidden={account === "Gleaner Group" || account === "Organization"}>
                                <TextField
                                    required
                                    fullWidth
                                    id="email"
                                    label="Email Address"
                                    name="email"
                                    autoComplete="email"
                                />
                            </Grid>
                            <Grid item xs={12} hidden={account === "Gleaning Group" || account === "Organization"}>
                                <MuiTelInput
                                    required
                                    fullWidth
                                    defaultCountry={'CA'}
                                    value={tel}
                                    name="phone"
                                    label="Phone Number"
                                    id="phoneNumber"
                                    autoComplete="Phone Number"
                                    onChange={handleTelChange}
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    name="address"
                                    label="Street Address"
                                    type="address"
                                    id="address"
                                    autoComplete="address"
                                />
                            </Grid>
                            <Grid item xs={12} sm={6} hidden={account === "Organization" || account === "Producer" || account === "Gleaner"}>
                                <TextField
                                    autoComplete="region"
                                    name="Region"
                                    required
                                    fullWidth
                                    id="region"
                                    label="Region"
                                    autoFocus
                                />
                            </Grid>
                            <Grid item xs={12} sm={6}>
                                <TextField
                                    autoComplete="city"
                                    name="City"
                                    required
                                    fullWidth
                                    id="city"
                                    label="City"
                                    autoFocus
                                />
                            </Grid>
                            <Grid item xs={12} sm={6}>
                                <TextField
                                    required
                                    fullWidth
                                    id="postalCode"
                                    label="Postal Code"
                                    name="postal"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    name="username"
                                    label="Username"
                                    type="username"
                                    id="username"
                                    autoComplete="username"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    name="password"
                                    label="Password"
                                    type="password"
                                    id="password"
                                    autoComplete="new-password"
                                />
                            </Grid>
                            <Grid
                                    item xs={12}
                                    hidden={account === "Gleaner Group" || account === "Producer" || account === "Gleaner"}>
                                <TextField
                                    name="maxDistance"
                                    required
                                    fullWidth
                                    id="maxDistance"
                                    label="Max Distance"
                                    autoFocus
                                    multiline={true}
                                    minRows={1}
                                    maxRows={200}
                                />
                            </Grid>
                            <Grid
                                item xs={12}
                                hidden={account === "Gleaner Group" || account === "Producer" || account === "Gleaner"}>
                                <TextField
                                    autoComplete="websiteLink"
                                    name="websiteLink"
                                    required
                                    fullWidth
                                    id="websiteLink"
                                    label="Website Link"
                                    autoFocus
                                    multiline={true}
                                    minRows={1}
                                    maxRows={200}
                                />
                            </Grid>
                        </Grid>
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            sx={{ mt: 3, mb: 2 }}
                        >
                            Sign Up
                        </Button>
                        <Grid container justifyContent="flex-end">
                            <Grid item>
                                <Link href="#" variant="body2">
                                    Already have an account? Sign in
                                </Link>
                            </Grid>
                        </Grid>
                    </Box>
                </Box>
            </Container>
        </ThemeProvider>
    );
}
