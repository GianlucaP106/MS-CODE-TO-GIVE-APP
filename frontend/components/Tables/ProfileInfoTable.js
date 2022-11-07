import React from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleDown, faAngleUp, faArrowDown, faArrowUp, faEdit, faEllipsisH, faExternalLinkAlt, faEye, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Col, Row, Nav, Card, Image, Button, Table, Dropdown, ProgressBar, Pagination, ButtonGroup } from '@themesberg/react-bootstrap';
import { Link } from 'react-router-dom';

const pageVisits = [
    { value: "Parsa", name: "Full Name" },
    { value: "Aditya", name: "email" },
    { value: "Montreal", name: "Address" },
    { value: "Pipi", name: "Caca" },
    { value: "Ta Face", name: "dans" }
];

export default function ProfileInfoTable (props) {
    const { firstSpot, secondSpot, thirdSpot, fourthSpot, profileType } = props;

    let firstKey, firstVal, secondKey, secondVal, thirdKey, thirdVal, fourthKey, fourthVal;
    
    firstVal = firstSpot;
    secondVal = secondSpot;
    thirdVal = thirdSpot;
    fourthVal = fourthSpot;

    if (profileType === "Volunteer"){
        firstKey = "First Name";
        secondKey = "Last Name";
        thirdKey = "Username";
        fourthKey = "Email";
    } else if (profileType === "FoodBank"){
        firstKey = "Name";
        secondKey = "Description";
        thirdKey = "Mission Statement";
        fourthKey = "Region(s)";
    } else if (profileType === "Group") {
        firstKey = "Name";
        secondKey = "Region";
        thirdKey = "Mission Statement";
        fourthKey = "Description";
    } else if (profileType === "Producer") {
        firstKey = "Name";
        secondKey = "Address";
        thirdKey = "Mission Statement";
        fourthKey = "Description";
    } else if (profileType === "Event") {
        firstKey = "Name";
        secondKey = "Address";
        thirdKey = "Mission Statement";
        fourthKey = "Description";
    }

    return (<div className="card mb-4">
    <div className="card-body">
      <div className="row">
        <div className="col-sm-3">
          <p className="mb-0">First Name:</p>
        </div>
        <div className="col-sm-9">
          <p className="text-muted mb-0">{firstVal}</p>
        </div>
      </div>
      <hr/>      
      <div className="row">
        <div className="col-sm-3">
          <p className="mb-0">Last Name:</p>
        </div>
        <div className="col-sm-9">
          <p className="text-muted mb-0">{thirdVal}</p>
        </div>
      </div>
      <hr/>
      <div className="row">
        <div className="col-sm-3">
          <p className="mb-0">Email</p>
        </div>
        <div className="col-sm-9">
          <p className="text-muted mb-0">{secondVal}</p>
        </div>
      </div>
      <hr/>
      <div className="row">
        <div className="col-sm-3">
          <p className="mb-0">Username:</p>
        </div>
        <div className="col-sm-9">
          <p className="text-muted mb-0">{fourthVal}</p>
        </div>
      </div>
    </div>
  </div>)
  };