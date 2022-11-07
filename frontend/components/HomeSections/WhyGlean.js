import React from 'react';
import { styled } from '@mui/material/styles';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import styles from '../../styles/components/HomeSections/WhyGlean.module.css';

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));

export default function WhyGlean() {
  return (
    <Box className={styles.box} sx={{ width: '100%' }}>
      <h2 className={styles.title}>Why should you <span className={styles.bold}>GLEAN</span>?</h2>
      <div className={styles.subtext}>The statistics are startling, yet revealing: According to estimates, nearly one-third of the U.S. food supply goes uneaten and wasted annually.
        The concept with the intriguing and arguably catchy name <span className={styles.bold}>gleaning</span> gives nonprofits and volunteers the opportunity to pick ripe produce that would otherwise go uneaten.
      </div>
      <div className={styles.subtext2}>Here are some data the U.S. Department of Agriculture’s Economic Research Service assembled in early 2014 showing the importance of gleaning:</div>
      <Box className={styles.body}>
        <Grid className={`${styles.infoContainder}`} container rowSpacing={20} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
          <Grid className={styles.stats} item xs={4}>
            <div className={styles.number}><p style={{marginTop: "33%"}}>31%</p></div>
            <div className={styles.statDescription}>Thirty-one percent of the nation’s food supply went uneaten that particular study year. </div>
          </Grid>
          <Grid className={styles.stats} item xs={4}>
            <div className={styles.number} style={{ fontSize: '5.5em' }}><p>133 billion pounds</p></div>
            <div className={styles.statDescription}>Of the 430 billion pounds of produce available, 133 billion pounds were uneaten (the difference represents the 31-percent figure).  </div>
          </Grid>
          <Grid className={styles.stats} item xs={4}>
            <div className={styles.number} style={{ fontSize: '6em' }}><p style={{marginTop: "17%"}}>$161.6 billion</p></div>
            <div className={styles.statDescription}>In terms of retail prices, the wasted post-harvested food was valued at $161.6 billion. </div>
          </Grid>
        </Grid>
      </Box>
    </Box >
  );
}
