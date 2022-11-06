import React from 'react'
import PageVisitsTable from '../Tables/PageVisitsTable'
import ProfileInfoTable from '../Tables/ProfileInfoTable'
import ProfileCard from "./ProfileCard"
import ProfileComment from "../Profiles/ProfileComment"

export default function ProfilePage() {
    const pageVisits = [
      { id: 1, date: "Nov 2022", comment: "Very good" },
      { id: 1, date: "Nov 2022", comment: "Not bad" },
      { id: 1, date: "Dec 2022", comment: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et ut" },
      { id: 1, date: "Nov 1231", comment: "Very okay" },
      { id: 1, date: "Nov 2022", comment: "Very good" },
      { id: 1, date: "Nov 2022", comment: "Very good" }
    ];

    return (<>
      <section styles="background-color: #eee;">
        <div className="container py-5">
          <div className="row">
            <div className="col-lg-4">
              <ProfileCard name={"Parsa Langari"} role={"Volunteer"} region={"Montreal"} 
                imgSrc={"https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"}/>
              <ProfileComment comments={pageVisits}/>
            </div>
            <div className="col-lg-8">
              <ProfileInfoTable firstSpot={"Parsa"} secondSpot={"Langari"} thirdSpot={"PLangari"} fourthSpot={"parsa.langari@mail.mcgill.ca"} profileType={"Volunteer"}/>
              <div className="row">
                <div className="col-md-6">
                  <div className="card mb-4 mb-md-0">
                    <div className="card-body">
                      <p className="mb-4"><span className="text-primary font-italic me-1">assigment</span> Project Status
                      </p>
                      <p className="mb-1" styles="font-size: .77rem;">Web Design</p>
                      <div className="progress rounded" styles="height: 5px;">
                        <div className="progress-bar" role="progressbar" styles="width: 80%" aria-valuenow="80"
                          aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                      <p className="mt-4 mb-1" styles="font-size: .77rem;">Website Markup</p>
                      <div className="progress rounded" styles="height: 5px;">
                        <div className="progress-bar" role="progressbar" styles="width: 72%" aria-valuenow="72"
                          aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                      <p className="mt-4 mb-1" styles="font-size: .77rem;">One Page</p>
                      <div className="progress rounded" styles="height: 5px;">
                        <div className="progress-bar" role="progressbar" styles="width: 89%" aria-valuenow="89"
                          aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                      <p className="mt-4 mb-1" styles="font-size: .77rem;">Mobile Template</p>
                      <div className="progress rounded" styles="height: 5px;">
                        <div className="progress-bar" role="progressbar" styles="width: 55%" aria-valuenow="55"
                          aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                      <p className="mt-4 mb-1" styles="font-size: .77rem;">Backend API</p>
                      <div className="progress rounded mb-2" styles="height: 5px;">
                        <div className="progress-bar" role="progressbar" styles="width: 66%" aria-valuenow="66"
                          aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="col-md-6">
                  <div className="card mb-4 mb-md-0">
                    <div className="card-body">
                      <p className="mb-4"><span className="text-primary font-italic me-1">assigment</span> Project Status
                      </p>
                      <p className="mb-1" styles="font-size: .77rem;">Web Design</p>
                      <div className="progress rounded" styles="height: 5px;">
                        <div className="progress-bar" role="progressbar" styles="width: 80%" aria-valuenow="80"
                          aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                      <p className="mt-4 mb-1" styles="font-size: .77rem;">Website Markup</p>
                      <div className="progress rounded" styles="height: 5px;">
                        <div className="progress-bar" role="progressbar" styles="width: 72%" aria-valuenow="72"
                          aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                      <p className="mt-4 mb-1" styles="font-size: .77rem;">One Page</p>
                      <div className="progress rounded" styles="height: 5px;">
                        <div className="progress-bar" role="progressbar" styles="width: 89%" aria-valuenow="89"
                          aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                      <p className="mt-4 mb-1" styles="font-size: .77rem;">Mobile Template</p>
                      <div className="progress rounded" styles="height: 5px;">
                        <div className="progress-bar" role="progressbar" styles="width: 55%" aria-valuenow="55"
                          aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                      <p className="mt-4 mb-1" styles="font-size: .77rem;">Backend API</p>
                      <div className="progress rounded mb-2" styles="height: 5px;">
                        <div className="progress-bar" role="progressbar" styles="width: 66%" aria-valuenow="66"
                          aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
    );
}