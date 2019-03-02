import React from "react";
import Group from "./Group";
import NewGroup from "./NewGroup";

class GroupPage extends React.Component {
  render() {
    return (
      <div>
        <Group />
        <NewGroup />
      </div>
    );
  }
}

export default GroupPage;
