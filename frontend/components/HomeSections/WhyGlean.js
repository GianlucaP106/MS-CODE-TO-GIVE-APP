import React from 'react';
import Polar from '../Charts/Polar'
import { styled } from '@mui/material/styles';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import styles from "../../styles/components/HomeSections/WhyGlean.module.css"

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));

export default function WhyGlean() {
  return (
      <div style={{height: "100vh"}}>
          <div className='row'>
            <div className={`col-5 ${styles.glean}`}>
            <Item>
               <h1><b>Why Should You Glean?</b></h1>
               <h3>Lorem ipsum dolor sit amet, consectetur adip occum sociosqu ad minim veniam Lore Lorem ipsum dolor sit amet, consectetur adip</h3>
               <hr/>
               <h3>To learn more about the impacts of Gleaning, checkout <a href='www.google.com/?q="Gleaning"'></a></h3>
           </Item>
            </div>
            <div className={`col-7`}>
              <div className={styles.glean}>
                <Item className={styles.polar}>
                  <Polar className={""} labels={["pie", "fruit"]} values={[10, 2]} />
                </Item>
              </div>
            </div>
          </div>
      </div>
    );
  }
  
  // <Box sx={{ width: '100%' }}>
  //   <Grid container rowSpacing={20} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
  //     <Grid item xs={5}>
  //         <Item>
  //             <h1><b>Why Should You Glean?</b></h1>
  //             <h3>Lorem ipsum dolor sit amet, consectetur adip occum sociosqu ad minim veniam Lore Lorem ipsum dolor sit amet, consectetur adip</h3>
  //             <hr/>
  //             <h3>To learn more about the impacts of Gleaning, checkout <a href='www.google.com/?q="Gleaning"'></a></h3>
  //         </Item>
  //     </Grid>
  //     <Grid item xs={7}>
  //         <Item>
  //             <Polar className={""} labels={["pie", "fruit"]} values={[10, 2]} />
  //         </Item>
  //     </Grid>
  //   </Grid>
  // </Box>