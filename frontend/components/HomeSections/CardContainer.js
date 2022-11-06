import React from 'react';
import HomepageCard from '../Cards/HomepageCard';

export default function CardContainer(props) {
    return (
        <div class="container" style={{alignItems: 'center'}}>
            <div class="row" >
                <div class="col-md">
                    <HomepageCard imgSrc={"./ecologo.png"} title={"Environmental benefits"} 
                        cardText ={"Lorem Ipsum is Lorem Ipsum but"} buttonLink={"https://www.calculator.net/gdp-calculator.html"}/>
                </div>
                <div class="col-md">
                    <HomepageCard imgSrc={"./ecologo.png"} title={"Environmental benefits"} 
                        cardText ={"Lorem Ipsum is Lorem Ipsum but"} buttonLink={"https://www.calculator.net/gdp-calculator.html"}/>                </div>
                <div class="col-md">
                    <HomepageCard imgSrc={"./ecologo.png"} title={"Environmental benefits"} 
                        cardText ={"Lorem Ipsum is Lorem Ipsum but"} buttonLink={"https://www.calculator.net/gdp-calculator.html"}/>                </div>
            </div>
        </div>
    )
}