import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faAngleDown,
  faAngleUp,
  faGlobeEurope,
} from "@fortawesome/free-solid-svg-icons";
import { Col, Row, Card } from "@themesberg/react-bootstrap";

export default function CounterWidget(props) {
  const { icon, iconColor, category, title, period, percentage } = props;
  const percentageIcon = percentage < 0 ? faAngleDown : faAngleUp;
  const percentageColor = percentage < 0 ? "text-danger" : "text-success";

  return (
    <Card border="light" className="shadow-sm">
      <Card.Body style={{background: "linear-gradient(#e66465, #9198e5);", margin : 10}}>
        <Row className="d-block d-xl-flex align-items-center">
          <Col
            xl={5}
            className={
              "text-xl-center d-flex align-items-center justify-content-xl-center mb-3 mb-xl-0"
            }
          >
            <div
              className={`icon icon-shape icon-md icon-${iconColor} rounded me-4 me-sm-0`}
            >
              <FontAwesomeIcon icon={icon} />
            </div>
          </Col>
          <Col xs={12} xl={7} className="px-xl-0">
            <div className="d-none d-sm-block">
              <h5 style={{ fontSize: 25 }}>{category}</h5>
              <h3 style={{ fontSize: 30 }} className="mb-1">
                {title}
              </h3>
            </div>
            <small style={{ fontSize: 15 }}>
              {period}, <FontAwesomeIcon icon={faGlobeEurope} size="xs" />{" "}
              WorldWide
            </small>
            <div className="small mt-2" style={{ fontSize: 15 }}>
              <FontAwesomeIcon
                icon={percentageIcon}
                className={`${percentageColor} me-1`}
              />
              <span className={`${percentageColor} fw-bold`}>
                {percentage}%
              </span>{" "}
              Since last month
            </div>
          </Col>
        </Row>
      </Card.Body>
    </Card>
  );
}
