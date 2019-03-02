import React from "react";
import { Table, Container, Row } from "reactstrap";
import PropTypes from "prop-types";
import axios from "axios";
import Groups from "./Groups";

class Group extends React.Component {
  handleRemove = Group => {
      const url = "http://localhost:8081/api/groups/{title}";
    axios
      .delete(url)
      .then(res => {
        this.setState(previousState => {
          return {
            Groups: previousState.Groups.filter(d => d.id !== Groups.id)
          };
        });
      })
      .catch(err => {
        console.log(err);
      });
  };
  handleRemoveE(event) {
    alert("Grupė " + this.state.title + " ištrintas");
    event.preventDefault();
  }

  removeGroup = (e, Group) => {
    e.preventDefault();
    if (this.props.removeClick) {
      this.props.removeClick(Group);
    }
  };
  render() {
    return (
      <div>
        <Container>
          <Row>
            <Table>
              <thead>
                <tr>
                  <th>Pavadinimas</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>{this.props.title}</td>
                </tr>
                {/* <button type="submit" onClick={e => this.removeGroup(e, Group)}>
                  Ištrinti
                </button>
                <button type="submit" onClick={e => this.editGroup(e, Group)}>
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
Group.Prototypes = {
  title: PropTypes.string.isRequired
};

export default Group;
