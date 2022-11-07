
import { useState, useEffect } from "react"
import styles from '../../styles/components/Event/Event.module.css';

const Event = (props) => {

    const [eventInfo, setEventInfo] = useState();
    const {teamInfo, setTeamInfo} = useState();

    useEffect(() => {
        const id  = props.id;
        // fetching event and related info
        getEventInfo(id);
    }, [])
    
    async function getEventInfo(id){
        const inputID = {
            ID : id
        };

        //first fetch event info
        let response = await fetch('http://localhost:8080/event/detail-event-info', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body : JSON.stringify(inputID)
        });

        response = await response.json();
        setEventInfo(response);

        console.log(response);
    }

    return (
        <div className={`${styles.wrapper}`}>

        </div>
    )
}


export default Event;