import React from 'react'
import FarmerLeaderboard from './Leaderboards/FarmerLeaderboard'
import GleanerLeaderboard from './Leaderboards/GleanerLeaderboard'
import Polar from './Charts/Polar'
import styles from '../styles/components/Statistics.module.css'

export default function Statistics() {
  return (
    <>
    <div className={styles.container}>
        <GleanerLeaderboard />
        <FarmerLeaderboard />
    </div>
    <div className={styles.container}>
        <Polar />
    </div>
    </>
  )
}
