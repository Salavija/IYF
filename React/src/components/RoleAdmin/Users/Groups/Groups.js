import React, { Component } from "react";
import PropTypes from "prop-types";
import Group from "./Group";
import { Table } from "reactstrap";

class Groups extends Component {
  render() {
    return (
          <Table>
            <thead>
              <tr>
                <th>Pavadinimas</th>
              </tr>
            </thead>
            <tbody>
              {this.props.groups.map(group => (
                <Group 
                  onGroupDeleted={this.props.onGroupDeleted}
                  group={group}
                //   a={console.log(group.id)} konsologingui
                  key={group.id}
                />
              ))}
            </tbody>
          </Table>
    );
  }
}
Groups.propTypes = {
  groups: PropTypes.array.isRequired
};
export default Groups;
