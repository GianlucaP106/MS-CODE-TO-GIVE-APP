import React from "react";
import { Col, Row, Card, Table } from '@themesberg/react-bootstrap';

export default function ProfileComment (props) {
    const { comments } = props;
    const TableRow = (props) => {
      const { date, comment } = props;
  
      return (
        <tr>
          <th scope="row">{date}</th>
          <td>{comment}</td>
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
          </Row>
        </Card.Header>
        <Table responsive className="align-items-center table-flush">
          <thead className="thead-light">
            <tr>
              <th scope="col">Published Date</th>
              <th scope="col">Comment</th>
            </tr>
          </thead>
          <tbody>
            {comments.map(pv => <TableRow {...pv} />)}
          </tbody>
        </Table>
      </Card>
    );
  };