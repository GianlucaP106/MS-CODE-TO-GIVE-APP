import styles from '../../../styles/Filter.module.css';

export default function ProducerFilters(props) {

    return props.trigger ? (
        <div className={styles.filter}>
            <>
                <input type="radio" id="producer-username" name="age" value="1"/>
                <label for="producer-username">Username</label><br/>  
            </>
            <>
                <input type="radio" id="producer-firstName" name="age" value="2"/>
                <label for="producer-firstName">First Name</label><br/>
            </>
            <>
                <input type="radio" id="producer-lastName" name="age" value="3"/>
                <label for="producer-lastName">Last Name</label><br/>  
            </>
            <>
                <input type="radio" id="producer-city" name="age" value="4"/>
                <label for="producer-city">City</label><br/>
            </>
        </div>
    ) : "";
}