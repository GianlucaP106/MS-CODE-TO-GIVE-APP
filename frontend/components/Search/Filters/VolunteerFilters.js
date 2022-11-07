import styles from '../../../styles/Filter.module.css';

export default function VolunteerFilter(props) {

    return props.trigger ? (
        <div className={styles.filter}>
            <>
                <input type="radio" id="producer-username" name="age" value="60"/>
                <label for="producer-username">Username</label><br/>  
            </>
            <>
                <input type="radio" id="producer-firstName" name="age" value="100"/>
                <label for="producer-firstName">First Name</label><br/>
            </>
            <>
                <input type="radio" id="producer-lastName" name="age" value="60"/>
                <label for="producer-lastName">Last Name</label><br/>  
            </>
            <>
                <input type="radio" id="producer-city" name="age" value="100"/>
                <label for="producer-city">City</label><br/>
            </>
        </div>
    ) : "";
}