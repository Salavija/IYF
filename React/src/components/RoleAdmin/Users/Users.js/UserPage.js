import React from "react";
import User from "./User";
import UsersSearch from "./UsersSearch";

class UserPage extends React.Component {
    render() {
        return (
          <div>
              <UsersSearch />
              <User />
          </div>
        );
    }
}

export default UserPage;
