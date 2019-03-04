import React from "react";
import User from "./User";
import UsersSearch from "./UsersSearch";
import { Button, Row, Col } from "reactstrap";
import { Link } from "react-router-dom";

class UserPage extends React.Component {
    render() {
        return (
          <div>
              <br></br>
              <Row>
                    <Col xs="auto">
                <Link to={"/create-user"}>
                <Button type="submit" color="primary">Kurti naują</Button>{" "}
                </Link>
                </Col>
                    <Col xs="auto">
              <UsersSearch />
              </Col>
                </Row>
              <User />
          </div>
        );
    }
}

export default UserPage;
