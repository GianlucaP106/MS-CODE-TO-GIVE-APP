import React from 'react'
import LeaderboardGleaner from './LeaderboardGleaner'
import Avatar from "@mui/material/Avatar";
import styles from '../../styles/components/Leaderboards/GleanerLeadboard.module.css'


export default function GleanerLeaderboard() {

    const rows = [
        { id: 1,
            volunteer: {
            username: "Harry Potter",
            avatar:'./Gleaners/Imaginary1.png'
          }, 
          total: '412', 
          timeSpent: '120'},
        { id: 2,
            volunteer: {
            username: "Particia Walton",
            avatar:'./Gleaners/Imaginary2.png'
            },
            total: '350',
            timeSpent: '108'},
        { id: 3,
            volunteer: {
            username: "Hellen Herman",
            avatar:'./Gleaners/Imaginary3.png'
            },
            total: '342',
            timeSpent: '106'},
        { id: 4,
            volunteer: {
            username: "David Davis",
            avatar:'./Gleaners/Imaginary4.png'
            },
            total: '267',
            timeSpent: '98'},
        { id: 5,
            volunteer: {
            username: "Petra Peterson",
            avatar:'./Gleaners/Imaginary5.png'
            },
            total: '258',
            timeSpent: '98'},
    ];

    const columns = [
        {
            field: "volunteer",
            headerName: "Gleaner",
            width: 200,
            renderCell: (params) => {
              return (
                <>
                  <Avatar src={params.value.avatar} />
                    <span className={styles.username}>{params.value.username}</span>
                </>
              );
            }
          },
        { field: 'total', headerName: 'Amount of crops saved (kg)', width: 150 },
        { field: 'timeSpent', headerName: 'Time Spent Gleaning (Hours)', width: 150 },
        { 
            field: 'average', 
            headerName: 'Gleaning rate (kg/Hour)', 
            width: 150, 
            valueGetter: (params) =>
            Math.round(params.row.total/params.row.timeSpent * 10) / 10,  
        },
    ];

    return (
        <LeaderboardGleaner rows={rows} columns={columns} className={styles.leaderboard} />
    )
}