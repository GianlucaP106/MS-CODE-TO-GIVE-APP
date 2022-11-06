import React from "react";

export default function ProfileCard(props){
    const { name, role, region, imgSrc } = props;
    return (
        <div className="card mb-4">
            <div className="card-body text-center">
                <img src={imgSrc} alt="avatar"
                className="rounded-circle profile_icon" styles={{height: 20}} />
                <h5 className="my-3">{name}</h5>
                <p className="text-muted mb-4">{role}, {region}</p>
            </div>
        </div>
    )
}