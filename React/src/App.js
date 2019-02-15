import React, { Component } from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";

import Home from "./components/Home";
// import About from "./components/About";
import Error from "./components/Error";
import Navigation from "./components/Navigation";
import Docs from "./components/Documents/DocumentsList/DocumentsListPage";
import NewDocument from "./components/Documents/NewDocument/CreateNew";
import Types from "./components/Documents/Types/TypePage";
// import Paperbase from './components/Header/Paperbase';
// import Navi from './components/Navi';

import { Container } from "reactstrap";
import GroupPage from "./components/Users/Groups/GroupPage";
import UserPage from "./components/Users/Users.js/UserPage";
import CreateUserPage from "./components/Users/CreateUser/CreateUserPage";

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
