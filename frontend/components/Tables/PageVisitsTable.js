import React from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleDown, faAngleUp, faArrowDown, faArrowUp, faEdit, faEllipsisH, faExternalLinkAlt, faEye, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Col, Row, Nav, Card, Image, Button, Table, Dropdown, ProgressBar, Pagination, ButtonGroup } from '@themesberg/react-bootstrap';
import { Link } from 'react-router-dom';

const pageVisits = [
    { id: 1, views: 4.525, returnValue: 255, bounceRate: 42.55, pageName: "/demo/admin/index.html" },
    { id: 2, views: 2.987, returnValue: 139, bounceRate: -43.52, pageName: "/demo/admin/forms.html" },
    { id: 3, views: 2.844, returnValue: 124, bounceRate: -32.35, pageName: "/demo/admin/util.html" },
    { id: 4, views: 1.220, returnValue: 55, bounceRate: 15.78, pageName: "/demo/admin/validation.html" },
    { id: 5, views: 505, returnValue: 3, bounceRate: -75.12, pageName: "/demo/admin/modals.html" }
];


export default function PageVisitsTable () {
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
  
    return (
      <Card border="light" className="shadow-sm">
        <Card.Header>
          <Row className="align-items-center">
            <Col>
              <h5>Page visits</h5>
            </Col>
            <Col className="text-end">
              <Button variant="secondary" size="sm">See all</Button>
            </Col>
          </Row>
        </Card.Header>
        <Table responsive className="align-items-center table-flush">
          <thead className="thead-light">
            <tr>
              <th scope="col">Page name</th>
              <th scope="col">Page Views</th>
              <th scope="col">Page Value</th>
              <th scope="col">Bounce rate</th>
            </tr>
          </thead>
          <tbody>
            {pageVisits.map(pv => <TableRow key={`page-visit-${pv.id}`} {...pv} />)}
          </tbody>
        </Table>
      </Card>
    );
  };