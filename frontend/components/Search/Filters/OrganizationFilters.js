import styles from '../../../styles/Filter.module.css';

export default function OrganizationFilters(props) {

    return props.trigger ? (
        <div className={styles.filter}>
            <>
                <input type="radio" id="organization-name" name="age" value="60"/>
                <label for="organization-name">Name</label><br/>  
            </>
            <>
                <input type="radio" id="organization-city" name="age" value="100"/>
                <label for="organization-city">City</label><br/>
            </>
        </div>
    ) : "";
}