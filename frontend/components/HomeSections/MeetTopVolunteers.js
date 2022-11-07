import React from 'react';
import GleanerLeaderboard from '../Leaderboards/GleanerLeaderboard'
import { styled } from '@mui/material/styles';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Bar from '../Charts/Bar'
import styles from "../../styles/components/HomeSections/WhyGlean.module.css"


const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));

export default function MeetTopVolunteers() {
  return (
      <div className="m-5 d-flex">
            <div className='p-3 col-lg-6'>
                <h1 className=''><b >Meet our top Gleaners</b></h1>
                <h3>These individuals have made exeptional efforts to reduce food waste.</h3>
                <hr/>
                <GleanerLeaderboard />
            </div>
          <div className='p-3 col-lg-6'>
              <h1 ><b className={styles.username}>Amount of crops saved (kg)</b></h1>
              <Bar className={""} labels={['Harry',"Particia","Hellen","David","Petra"]} values={[412, 350,342,267,258]} />
          </div>
      </div>
  );
}
