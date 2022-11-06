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

export default function ProfileInfo (props) {
    const { icon, dictionary } = props;
    const TableRow = (props) => {
        const { pageName, views, returnValue, bounceRate } = props;
        const bounceIcon = bounceRate < 0 ? faArrowDown : faArrowUp;
        const bounceTxtColor = bounceRate < 0 ? "text-danger" : "text-success";
    
        return (
          <tr>
            <th scope="row">{pageName}</th>
            <td>{views}</td>
            <td>${returnValue}</td>
            <td>
              <FontAwesomeIcon icon={bounceIcon} className={`${bounceTxtColor} me-3`} />
              {Math.abs(bounceRate)}%
            </td>
          </tr>
        );
      };

    // return (
    //     <Table responsive className="align-items-center table-flush">
    //       <tbody>
    //         {pageVisits.map(pv => <TableRow key={`page-visit-${pv.id}`} {...pv} />)}
    //       </tbody>
    //     </Table>
    // );

    return (<div className="card mb-4">
    <div className="card-body">
      <div className="row">
        <div className="col-sm-3">
          <p className="mb-0">Full Name</p>
        </div>
        <div className="col-sm-9">
          <p className="text-muted mb-0">Johnatan Smith</p>
        </div>
      </div>
      <hr/>
      <div className="row">
        <div className="col-sm-3">
          <p className="mb-0">Email</p>
        </div>
        <div className="col-sm-9">
          <p className="text-muted mb-0">example@example.com</p>
        </div>
      </div>
      <hr/>
      <div className="row">
        <div className="col-sm-3">
          <p className="mb-0">Phone</p>
        </div>
        <div className="col-sm-9">
          <p className="text-muted mb-0">(097) 234-5678</p>
        </div>
      </div>
      <hr/>
      <div className="row">
        <div className="col-sm-3">
          <p className="mb-0">Mobile</p>
        </div>
        <div className="col-sm-9">
          <p className="text-muted mb-0">(098) 765-4321</p>
        </div>
      </div>
      <hr/>
      <div className="row">
        <div className="col-sm-3">
          <p className="mb-0">Address</p>
        </div>
        <div className="col-sm-9">
          <p className="text-muted mb-0">Bay Area, San Francisco, CA</p>
        </div>
      </div>
    </div>
  </div>)
  };