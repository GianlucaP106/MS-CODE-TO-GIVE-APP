import React from 'react'
import Leaderboard from './Leaderboard'
import styles from '../../styles/components/Leaderboards/GleanerLeadboard.module.css'

export default function GleanerLeaderboard() {

    const rows = [
        { id: 1, name: 'Gleaner 1', total: '35', timeSpent: '5'},
        { id: 2, name: 'Gleaner 2', total: '35', timeSpent: '5'},
        { id: 3, name: 'Gleaner 3', total: '35', timeSpent: '5'},
        { id: 4, name: 'Gleaner 4', total: '35', timeSpent: '5'},
    ];

    const columns = [
        { field: 'name', headerName: 'Gleaner Name', width: 150 },
        { field: 'total', headerName: 'Harvest Gleaned', width: 150 },
        { field: 'timeSpent', headerName: 'Time Spent Gleaning (Hours)', width: 150 },
        { 
            field: 'average', 
            headerName: 'Average Harvest Gleaned/Hour', 
            width: 150, 
            valueGetter: (params) =>
            params.row.total/params.row.timeSpent,  
        },
    ];

    return (
        <Leaderboard rows={rows} columns={columns} className={styles.leaderboard} />
    )
}