import styles from '../../../styles/Filter.module.css';

export default function GleanerGroupFilters(props) {
    return props.trigger ? (
        <div className={styles.filter}>
            <>
                <input type="radio" id="group-name" name="age" value="60"/>
                <label for="group-name">Name</label>
                <br/>  
            </>
            <>
                <input type="radio" id="group-region" name="age" value="100"/>
                <label for="group-region">Region</label><br/>
            </>
        </div>
    ) : "";
}