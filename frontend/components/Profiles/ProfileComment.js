import { useEffect, useState } from "react";
import { Col, Row, Card, Table } from '@themesberg/react-bootstrap';
import TableRow from "./TableRow";

export default function ProfileComment(props) {

    const [ comments, setComments ] = useState(props.comments);

    useEffect(() => {
      setComments(props.comments)
    }, [props.comments]);
    
    return (
      <Card border="light" className="shadow-sm">
        <Card.Header>
          <Row className="align-items-center">
            <Col>
              <h5>Top Comments</h5>
            </Col>
          </Row>
        </Card.Header>
        <Table responsive className="align-items-center table-flush">
          <thead className="thead-light">
            <tr>
              <th scope="col">Published Date</th>
              <th scope="col">Comment</th>
              <th scope="col">Author</th>
            </tr>
          </thead>
          <tbody>
            {comments && comments.map(pv => <TableRow {...pv} />)}
          </tbody>
        </Table>
      </Card>
    );
  };