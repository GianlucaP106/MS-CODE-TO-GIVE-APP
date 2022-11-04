import React from 'react'
import Leaderboard from './Leaderboard'
import styles from '../../styles/components/Leaderboards/FarmerLeaderboard.module.css'

export default function FarmerLeaderboard() {
    const rows = [
        { id: 1, col1: 'Farmer 1', col2: '4', col3: '134', col4: 'Hover' },
        { id: 1, col1: 'Farmer 2', col2: '4', col3: '134', col4: 'Hover' },
    ];

    const columns = [
        { field: 'col1', headerName: 'Farmer Name', width: 150 },
        { field: 'col2', headerName: 'Gleaning Opportunities To Date', width: 150 },
        { field: 'col3', headerName: 'Harvests Gleaned', width: 150 },
        { field: 'col4', headerName: 'Harvest Breakdown', width: 150 },
    ];

  return (
    <Leaderboard rows={rows} columns={columns} className={styles.leaderboard} />
  )
}