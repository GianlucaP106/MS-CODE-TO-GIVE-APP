import React from 'react'
import PageVisitsTable from '../Tables/PageVisitsTable'
import ProfileInfoTable from '../Tables/ProfileInfoTable'
import ProfileCard from "./ProfileCard"
import ProfileComment from "../Profiles/ProfileComment"
import Leaderboard from "../Leaderboards/Leaderboard"

export default function ProfilePage({info}) {
    const pageVisits = [
      { id: 1, date: "Nov 2022", comment: "Very good" },
      { id: 1, date: "Nov 2022", comment: "Not bad" },
      { id: 1, date: "Dec 2022", comment: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et ut" },
      { id: 1, date: "Nov 1231", comment: "Very okay" },
      { id: 1, date: "Nov 2022", comment: "Very good" },
      { id: 1, date: "Nov 2022", comment: "Very good" }
    ];

    const rows = [
      { id: 1, col1: 'Ste-Eustache', col2: '4', col3: '134', col4: 'Hover' },
      { id: 2, col1: 'Laval', col2: '4', col3: '134', col4: 'Hover' },
    ];

    const columns = [
      { field: 'col1', headerName: 'Farmer Name', width: 150 },
      { field: 'col2', headerName: 'Gleaning Opportunities To Date', width: 150 },
      { field: 'col3', headerName: 'Harvests Gleaned', width: 150 },
      { field: 'col4', headerName: 'Harvest Breakdown', width: 150 }
    ];

    return (<>
      <section styles="background-color: #eee;">
        <div className="container py-5">
          <div className="row">
            <div className="col-lg-4">
              <ProfileCard name={info.username} role={info.personType} region={info.city} 
                imgSrc={"https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"}/>
              <ProfileComment comments={pageVisits}/>
            </div>
            <div className="col-lg-8">
              <ProfileInfoTable firstSpot={info.firstName} secondSpot={info.lastName} thirdSpot={info.username} fourthSpot={info.email} profileType={info.personType}/>
              <Leaderboard rows={rows} columns={columns} />
            </div>
          </div>
        </div>
      </section>
    </>
    );
}