import React from "react";
import User from "./User";
import UsersSearch from "./UsersSearch";
import { Container } from "reactstrap";

class UserPage extends React.Component {
    render() {
        return (
          <div>
              <Container>
              <UsersSearch />
              <User />
            </Container>
          </div>
        );
    }
}

export default UserPage;
