
import { useState, useEffect } from "react"
import styles from '../../styles/components/Event/Event.module.css';
import Image from 'next/image'
import gleaningImage from '../../public/gleaning.png'

const Event = (props) => {
    const [ eventInfo, setEventInfo ] = useState();

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

    function EventCard(){
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

    function RelatedFarm(){
        return(
            <div className={`${styles.farmWrapper}`}>
                <div className={`${styles.farmInfo}`}>
                    <div className={`${styles.farmName}`}>
                        {eventInfo.farm.farmName}
                    </div>
                    <hr class="hr hr-blurry" />
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

    function RelatedComments(){
        return(
            <div className={`${styles.commentWrapper}`}>
                <div className={`${styles.comments}`}>

                </div>
            </div>
        )
    }

    return (
        eventInfo && 
        <div className={`${styles.wrapper}`}>
            <div className={`${styles.eventfarm}`}>
                <EventCard/>
                <RelatedFarm/>
                <RelatedComments/>
            </div>
        </div>
    )
}


export default Event;