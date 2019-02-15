import React from "react";
import { Table, Container, Row } from "reactstrap";
import PropTypes from "prop-types";
import axios from "axios";

class UsersList extends React.Component {
  getUsers() {
    axios
      .get("https://localhost:8081/api/users")
      .then(response =>
        response.data.results.map(user => ({
          firstName: ``,
          lastName: ``,
          password: ``,
          userId: ``
        }))
      )
      // Let's make sure to change the loading state to display the data
      .then(users => {
        this.setState({
          users,
          isLoading: false
        });
      })
      // We can still use the `.catch()` method since axios is promise-based
      .catch(error => this.setState({ error, isLoading: false }));
  }
  render() {
    return (
      <div>
        <Container>
          <Row>
            <Table>
              <thead>
                <tr>
                  <th>Vardas</th>
                  <th>Pavardė</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>{this.props.firstName}</td>
                  <td>{this.props.lastName}</td>
                </tr>
                {/* <button
                  type="submit"
                  onClick={e => this.removeUser(e, user)}
                >
                  Ištrinti
                </button>
                <button
                  type="submit"
                  onClick={e => this.editUser(e, user)}
                >
                  Redaguoti
                </button> */}
              </tbody>
            </Table>
          </Row>
        </Container>
      </div>
    );
  }
}
Document.Prototypes = {
  firstName: PropTypes.string.isRequired,
  lastName: PropTypes.string.isRequired,
};

export default UsersList;
