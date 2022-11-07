
import { useState, useEffect } from "react"
import { useRouter } from "next/router"
import Event from '../../components/Event/Event.js'

const EventPage = ( props ) => {

    const router = useRouter();
    const [eventID, setEventID] = useState();

    useEffect(() => {
        setEventID(router.query.event);
        if (router.query) {
            console.log(router.query)
            setEventID(router.query.event);
            console.log(eventID);
        }
    }, [router.query]);


    return (
        eventID &&
        <div>
            <Event id={eventID}/>
        </div>
    )
}

export default EventPage;