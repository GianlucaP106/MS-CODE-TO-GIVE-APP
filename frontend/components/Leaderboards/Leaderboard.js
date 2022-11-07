import * as React from 'react';
import Box from '@mui/material/Box';
import { DataGrid } from '@mui/x-data-grid';
import styles from "../../styles/components/Leaderboards/Leaderboard.module.css";

export default function Leaderboard(props) {
  return (
    <Box sx={{ height: 400, width: '100%' }}>
      <DataGrid
        rows={props.rows}
        columns={props.columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
      />
    </Box>
  );
}

