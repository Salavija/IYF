import React from "react";
import PropTypes from "prop-types";
import axios from "axios";

class Group extends React.Component {
  handleRemove = () => {
    this.props.onGroupDeleted(this.props.group);
    const url = "http://localhost:8081/api/groups/" + this.props.group.title;
    axios
      .delete(url)
      // .then(res => {
      //  console.log(res)
      //     };
      .catch(err => {
        console.log(err);
      });
  };
  handleRemoveE(event) {
    alert("Grupė " + this.state.title + " ištrintas");
    event.preventDefault();
  }

  removeGroup = (e, group) => {
    e.preventDefault();
    if (this.props.removeClick) {
      this.props.removeClick(group);
    }
  };
  render() {
    return (
      <tr key={this.props.key}>
        <td>{this.props.group.title}</td>
        <button type="submit" onClick={this.handleRemove}>
          Ištrinti
        </button>
        {/* <button type="submit" onClick={e => this.editGroup(e, Group)}>
                  Redaguoti
                </button> */}
      </tr>
    );
  }
}
Group.Prototypes = {
  title: PropTypes.string.isRequired
  //kad mestu warningus
};

export default Group;
