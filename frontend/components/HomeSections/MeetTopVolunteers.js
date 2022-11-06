import React from 'react';
import GleanerLeaderboard from '../Leaderboards/GleanerLeaderboard'
import { styled } from '@mui/material/styles';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));

export default function MeetTopVolunteers() {
  return (
    <Box sx={{ width: '100%' }}>
      <Grid container rowSpacing={20} columnSpacing={0}>
        <Grid item xs={6}>
            <Item>
                <h1><b>Why Should You Glean?</b></h1>
                <h3>Lorem ipsum dolor sit amet, consectetur adip occum sociosqu ad minim veniam Lore Lorem ipsum dolor sit amet, consectetur adip</h3>
                <hr/>
                <GleanerLeaderboard />
            </Item>
        </Grid>
        <Grid item xs={6}>
          <img src="./volunteers.jpg" width="100%" height="auto"/>
        </Grid>
      </Grid>
    </Box>
  );
}
