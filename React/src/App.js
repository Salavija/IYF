import React, { Component } from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";

import Home from "./components/Home";
// import About from "./components/About";
import Error from "./components/Error";
import Navigation from "./components/Navigation";
import Docs from "./components/RoleUser/Documents/DocumentsList/DocumentsListPage";
import NewDocument from "./components/RoleUser/Documents/NewDocument/CreateNew";
import Types from "./components/RoleUser/Documents/Types/TypePage";
// import Paperbase from './components/Header/Paperbase';
// import Navi from './components/Navi';

import { Container } from "reactstrap";
import GroupPage from "./components/RoleAdmin/Users/Groups/GroupPage";
import UserPage from "./components/RoleAdmin/Users/Users.js/UserPage";
import CreateUserPage from "./components/RoleAdmin/Users/CreateUser/CreateUserPage";
import Login from './components/Login';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <div>
          <Container>
            <Navigation />
            {/* <Navi /> */}
            {/* <Paperbase /> */}
            <Switch>
              <Route path="/login" exact component={Login} />
              <Route path="/" component={Home} exact />
              <Route path="/users" component={UserPage} />
              <Route path="/create-user" component={CreateUserPage} />
              <Route path="/documents" component={Docs} />
              <Route path="/create-new-document" component={NewDocument} />
              <Route path="/types" component={Types} />
              <Route path="/groups" component={GroupPage} />
              <Route component={Error} />
            </Switch>
          </Container>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
