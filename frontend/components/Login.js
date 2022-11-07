import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
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
import {useState} from "react";

const theme = createTheme();


export default function SignInSide(props) {
    const [account, setAccount] = React.useState('');
    const [ userInformation, setUserInformation ] = useState();

    const handleChange = (event) => {
        setAccount(event.target.value);
        console.log(account)
        console.log(typeof account)
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget);
        verifyUser(
            data.get('username'),
            data.get('password')
        ).then((r) => {console.log("here now eh:", r)});
    };

    async function verifyUser(username_input, password_input) {
        let userInfo = null;

        if (account === "Gleaner") {
            console.log("im here");
            console.log(username_input);
            userInfo = await fetch(
                "http://localhost:8080/volunteer/sign-in",
                {
                    method: "POST",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        username : username_input, 
                        password : password_input
                    })
                });

                userInfo = await userInfo.json();
                props.setCredentials(userInfo);
                console.log(userInfo);
                const url = `http://localhost:3000/profile/${userInfo.ID}?type=volunteer`
                window.location.href = url;
        }

        if (account === "Organization") {

        }

        if (account === "Gleaning Group") {

        }

    }

    return (
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
                            Sign in
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
                        <Box hidden={account === ""} component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 1 }}>
                            <TextField
                                margin="normal"
                                required
                                fullWidth
                                id="username"
                                label="Username"
                                name="username"
                                autoComplete="username"
                                autoFocus
                            />
                            <TextField
                                margin="normal"
                                required
                                fullWidth
                                name="password"
                                label="Password"
                                type="password"
                                id="password"
                                autoComplete="current-password"
                            />
                            <Button
                                type="submit"
                                fullWidth
                                variant="outlined"
                                sx={{ mt: 3, mb: 2 }}
                            >
                                Sign In
                            </Button>
                            <Grid container>
                                <Grid item xs>
                                    <Link href="#" variant="body2">
                                        Forgot password?
                                    </Link>
                                </Grid>
                                <Grid item>
                                    <Link href="#" variant="body2">
                                        {"Don't have an account? Sign Up"}
                                    </Link>
                                </Grid>
                            </Grid>
                        </Box>
                    </Box>
                </Grid>
            </Grid>
        </ThemeProvider>
    );
}