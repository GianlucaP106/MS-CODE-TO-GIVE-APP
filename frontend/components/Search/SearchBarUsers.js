import { useState } from 'react';
import styles from '../../styles/Filter.module.css';
import { TextField, Button } from '@mui/material'
import React from 'react';
import IconButton from '@mui/material/IconButton';
import Menu from '@mui/material/Menu';
import VolunteerFilter from './Filters/VolunteerFilters';
import ProducerFilter from './Filters/ProducerFilters';
import OrganizationFilters from './Filters/OrganizationFilters';
import GleanerGroupFilters from './Filters/GleanerGroupFilters';
import FilterAltIcon from '@mui/icons-material/FilterAlt';
import PersonSearchIcon from '@mui/icons-material/PersonSearch';

export default function SearchBarUsers() {
  
  const [mobileMoreAnchorEl, setMobileMoreAnchorEl] = React.useState(null);

  const isMobileMenuOpen = Boolean(mobileMoreAnchorEl);

  const handleMobileMenuClose = () => {
      setMobileMoreAnchorEl(null);
  };

  const handleMobileMenuOpen = (event) => {
      setMobileMoreAnchorEl(event.currentTarget);
  };
  const [volFilters, setFilterVol] = useState(false);
  const [proFilters, setFilterPro] = useState(false);
  const [orgFilters, setFilterOrg] = useState(false);
  const [ggFilters, setFilterGG] = useState(false);

  const handleVol = event => {
      setFilterVol(!volFilters);
      console.log(volFilters);
  };
  const handlePro = event => {
      setFilterPro(!proFilters);
      console.log(proFilters);
  };
  const handleOrg = event => {
      setFilterOrg(!orgFilters);
      console.log(orgFilters);
  };
  const handleGG = event => {
      setFilterGG(!ggFilters);
      console.log(ggFilters);
  };

  const mobileMenuId = 'primary-searchBar-account-menu-mobile';
  const renderMobileMenu = (
      <Menu
          anchorEl={mobileMoreAnchorEl}
          anchorOrigin={{
              vertical: 'top',
              horizontal: 'right',
          }}
          id={mobileMenuId}
          keepMounted
          transformOrigin={{
              vertical: 'top',
              horizontal: 'left',
          }}
          open={isMobileMenuOpen}
          onClose={handleMobileMenuClose}
      >
          <>
          <div className={styles.popup}>
              <section>
                  <h3>Volunteer</h3>
                  <Button onClick={handleVol} style={{height:"57px"}}>
                      <picture><img src="chevron-down.png" alt="Italian Trulli"/></picture>
                  </Button>
              </section>
                  <VolunteerFilter trigger={volFilters}/>
              <section>
                  <h3>Producer</h3>
                  <Button onClick={handlePro} style={{height:"57px"}}>
                      <picture><img src="chevron-down.png" alt="Italian Trulli"/></picture>
                  </Button>
              </section>
              <ProducerFilter trigger={proFilters}/>
              <section>
                  <h3>Organization</h3>
                  <Button onClick={handleOrg} style={{height:"57px"}}>
                      <picture><img src="chevron-down.png" alt="Italian Trulli"/></picture>
                  </Button>
              </section>
              <OrganizationFilters trigger={orgFilters}/>
              <section>
                  <h3>GleanerGroup</h3>
                  <Button onClick={handleGG} style={{height:"57px"}}>
                      <picture><img src="chevron-down.png" alt="Italian Trulli"/></picture>
                  </Button>
              </section>
              <GleanerGroupFilters trigger={ggFilters}/>
          </div>
      </>

      </Menu>
  );

const [filterPopUp, setFilterPopUp] = useState(false);

const handleClick = event => {
  setFilterPopUp(!filterPopUp);
};

return (
  <>
  <div className={styles.main}>
      <Button color='inherit'>
        <PersonSearchIcon className={styles.button} />
      </Button>
      <IconButton
      size="large"
      edge="start"
      color="inherit"
      aria-label="open drawer"
      aria-haspopup="true"
      onClick={handleMobileMenuOpen}
      sx={{ mr: 2 }}
      >
        <FilterAltIcon className={styles.button} />
      </IconButton>
  </div>

    {renderMobileMenu}
  </>
)
}
