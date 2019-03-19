import React from "react";
import Groups from "./Groups";
import NewGroup from "./NewGroup";
import axios from "axios";
import TypesForGroups from './TypesForGroup';

class GroupPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      groups: [],
      page: 0,
      rowsPerPage: 5,
      types: [],
    };
  }
  handleChangePage = (event, page) => {
    this.setState({ page });
  };

  handleChangeRowsPerPage = event => {
    this.setState({ page: 0, rowsPerPage: event.target.value });
  };
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
    });
  };
  render() {
    return (
      <div>
        <NewGroup onGroupAdded={this.onGroupAdded} />
        <TypesForGroups 
          groups={this.state.groups}
          types={this.state.types}
        />
        <Groups
          groups={this.state.groups}
          onGroupDeleted={this.onGroupDeleted}
          page={this.state.page}
          rowsPerPage={this.state.rowsPerPage}
          handleChangePage={this.handleChangePage}
          handleChangeRowsPerPage={this.handleChangeRowsPerPage}
        />
      </div>
    );
  }
}

export default GroupPage;
