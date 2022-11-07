import { useState, useEffect } from "react"
import styles from '../../styles/components/Event/Event.module.css';
import Image from 'next/image'
import gleaningImage from '../../public/gleaning.png'
import PrimarySearchAppBar from "../Layout/PrimarySearchAppBar";
import { Col, Row, Card, Table } from '@themesberg/react-bootstrap';

const Event = (props) => {
    const [eventInfo, setEventInfo] = useState();

    useEffect(() => {
        const id = props.id;
        // fetching event and related info
        getEventInfo(id);
    }, [])

    async function getEventInfo(id) {
        const inputID = {
            ID: id
        };

        //first fetch event info
        let response = await fetch('http://localhost:8080/event/detail-event-info', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(inputID)
        });

        response = await response.json();
        setEventInfo(response);
        console.log(eventInfo);
    }

    function EventCard() {
        return (
            <div className={`${styles.eventCardWrapper}`}>
                <div className={`mb-5 ${styles.eventImage}`}>
                    <Image
                        src={gleaningImage}
                        width={150}
                        height={150}
                        alt="event glean card"
                    />
                </div>
                <div className={`${styles.eventDescription}`}>
                    <h3>
                        <div> Event Name</div> {eventInfo["event"]["eventName"]}
                    </h3>
                    <h3>
                        <div> Event description</div>  {eventInfo["event"]["description"]}
                    </h3>
                    <h3>
                        <div> Max Gleaners</div> {eventInfo["event"]["maxGleaners"]}
                    </h3>
                    <h3>
                        <div> Required Gleaners</div> {eventInfo["event"]["requiredGleaners"]}
                    </h3>
                    <button type="button" className={`${styles.participate} btn btn-primary`}>Register</button> </div>
            </div>
        )
    }

    function RelatedFarm() {
        return (
            <div className={`${styles.farmWrapper}`}>
                <div className={`${styles.farmInfo}`}>
                    <div className={`${styles.farmName}`}>
                        {eventInfo.farm.farmName}
                    </div>
                    <hr className="hr hr-blurry" />
                    <div className="mt-5 text-center">
                        {` address:
                            ${eventInfo.farm.address},   
                            ${eventInfo.farm.city}, 
                            ${eventInfo.farm.postalCode} 
                        `}
                    </div>
                </div>
                <hr className="hr hr-blurry" />
                <div className={`${styles.farmName}`}>
                    <a href={`/profile/${eventInfo.producer.id}?type=producer`}>
                        {`${eventInfo.producer.firstName} ${eventInfo.producer.lastName}`}
                    </a>
                </div>
                <div className={`text-center mt-5`} >
                    {` address:
                            ${eventInfo.producer.address},   
                            ${eventInfo.producer.city}, 
                            ${eventInfo.producer.postalCode} 
                        `}
                </div>
                <hr className="hr hr-blurry" />
                <div className={`text-center ${styles.producerInfo}`}>
                    <div className="mt-5 text-center">
                        Contact Information
                    </div>
                    <div className="mt-5">
                        {` 
                            phone number:  ${eventInfo.producer.phoneNumber}

                        `}
                    </div>
                    <div className="">
                        {` 
                            email: ${eventInfo.producer.email}
                        `}
                    </div>
                </div>
            </div>
        )
    }

    function RelatedComments() {
        return (
            <div className={`${styles.commentWrapper}`}>
                <div className={`${styles.comments}`}>
                    <Table className={`table ${styles.table}`}>
                        <thead className={`${styles.commentHead}`}>
                            <tr>
                                <th scope="col">Author type</th>
                                <th scope="col">Comments</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                eventInfo.comments.map(comment => {
                                    return (
                                        <tr>
                                            <td>{comment.authorType}</td>
                                            <td>{comment.comment}</td>
                                        </tr>
                                    )
                                })
                            } 
                            <tr>
                                <td>VOLUNTEER</td>
                                <td>I loved that event. I had a great time and the producer great!</td>
                            </tr>
                            <tr>
                                <td>ORGANIZATION</td>
                                <td>Lots of food was given to charity!!</td>
                            </tr>
                            <tr>
                                <td>VOLUNTEER</td>
                                <td>Very tiring day but also very rewarding</td>
                            </tr>
                            <tr>
                                <td>VOLUNTEER</td>
                                <td>I had a great time with friends and good people!</td>
                            </tr>
                        </tbody>
                    </Table>
                </div>
            </div>
        )
    }

    function PartcipatingVolunteers(){
        return(
            <div className={`${styles.participants}`}>
                <div className={`mt-5 ${styles.volWrapper}`}>
                    <Table className={`table ${styles.table}`}>
                            <thead className={`${styles.commentHead}`}>
                                <tr>
                                    <th scope="col">Volunteer ID</th>
                                    <th scope="col">First Name</th>
                                    <th scope="col">Last Name</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Team Number</th>
                                    <th scope="col">JoinTeam</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    eventInfo.teams[0].volunteers.map(volunteer => {
                                        return (
                                            <tr>
                                                <td><a href={`/profile/${volunteer.id}?type=volunteer`}>{volunteer.id}</a></td>
                                                <td>{volunteer.firstName}</td>
                                                <td>{volunteer.lastName}</td>
                                                <td>{volunteer.email}</td>
                                                <td>{eventInfo.teams[0].teamNumber}</td>
                                                <td>
                                                    <button className="btn btn-primary">
                                                        Join this Group
                                                    </button>
                                                </td>
                                            </tr>
                                        )
                                    })
                                } 
                            </tbody>
                        </Table>
                </div>

                <div className={`mt-5 ${styles.volWrapper}`}>
                    <Table className={`table ${styles.table}`}>
                            <thead className={`${styles.commentHead}`}>
                                <tr>
                                    <th scope="col">Organization ID</th>
                                    <th scope="col">Organization Name</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">website Link</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    eventInfo.organizations.map(org => {
                                        return (
                                            <tr>
                                                <td><a href={`/profile/${org.id}?type=organization`}>{org.id}</a></td>
                                                <td>{org.organizationName}</td>
                                                <td>{org.description}</td>
                                                <td><a href={org.websiteLink}>{org.websiteLink}</a></td>
                                            </tr>
                                        )
                                    })
                                } 
                            </tbody>
                        </Table>
                </div>
            </div>
        )
    }

    const produces = [
        { id: 1, name: "Apples", amount: 100},
        { id: 2, name: "Corn", amount: 130},
        { id: 3, name: "Beats", amount: 155},
        { id: 4, name: "Strawberries", amount: 25},
        { id: 5, name: "Peaches", amount: 77},
    ]

    function CropTable(){
        return(
            <div className={`${styles.participants}`}>
                <div className={`mt-5 ${styles.volWrapper}`}>
                    <Table className={`table ${styles.table}`}>
                            <thead className={`${styles.commentHead}`}>
                                <tr>
                                    <th scope="col">Produce ID</th>
                                    <th scope="col">Produce Name</th>
                                    <th scope="col">Expected Amount for harvest</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    produces.map(produce => {
                                        return (
                                            <tr>
                                                <td>{produce.id}</td>
                                                <td>{produce.name}</td>
                                                <td>{produce.amount}</td>
                                            </tr>
                                        )
                                    })
                                } 
                            </tbody>
                        </Table>
                </div>
            </div>
        )
    }

    return (
        eventInfo && 
        (
            <div>
                <PrimarySearchAppBar/>
                <div className={`${styles.wrapper}`}>
                    <div className={`${styles.eventfarm}`}>
                        <EventCard />
                        <RelatedFarm />
                        <RelatedComments />
                    </div>
                    <div className={`${styles.participantsWrapper}`}>
                        <PartcipatingVolunteers/>
                    </div>
                    <div className={`${styles.participantsWrapper}`}>
                        <CropTable/>
                    </div>
                </div>
            </div>
        )
    )
}

export default Event;