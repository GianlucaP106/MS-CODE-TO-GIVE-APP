
import { useState, useEffect } from "react"
import { useRouter } from "next/router"

const Event = ( props ) => {

    const router = useRouter();
    const {event} = router.query

    return (
        <div>
        </div>
    )
}

export default Event;