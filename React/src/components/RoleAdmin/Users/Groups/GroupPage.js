import React from "react";
import Groups from "./Groups";
import NewGroup from "./NewGroup";
import axios from "axios";

class GroupPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      groups: []
      // groups: props.groups
    };
  }
  componentDidMount = () => {
    axios
      .get("http://localhost:8081/api/groups")
      .then(answer => {
        this.setState({ groups: answer.data });
      })
      .catch(error => {
        console.log(error);
      });
  };

  onGroupAdded = group => {
    this.setState({ groups: [...this.state.groups, group] });
  };

  onGroupDeleted = group => {
    this.setState(previousState => {
      return {
        groups: previousState.groups.filter(d => d.title !== group.title)
  };
})
  }
  render() {
    return (
      <div>
        <NewGroup onGroupAdded={this.onGroupAdded} />
        <Groups groups={this.state.groups} onGroupDeleted={this.onGroupDeleted} />
      </div>
    );
  }
}

export default GroupPage;
