import React, { Component } from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import "./App.css";

import Home from "./components/Home";
// import About from "./components/About";
import Error from "./components/Error";
import Navigation from "./components/Navigation";
import Docs from "./components/RoleUser/Documents/DocumentsList/DocumentsListPage";
import NewDocument from "./components/RoleUser/Documents/NewDocument/CreateNew";
import Types from "./components/RoleUser/Documents/Types/TypePage";
import Paperbase from './components/Header/Paperbase';
// import Navi from './components/Navi';

import { Container } from "reactstrap";
import GroupPage from "./components/RoleAdmin/Users/Groups/GroupPage";
import UserPage from "./components/RoleAdmin/Users/Users.js/UserPage";
import CreateUserPage from "./components/RoleAdmin/Users/CreateUser/CreateUserPage";
// import Login from "./components/Login";
import Admin from "./components/RoleAdmin/AdminHome";
import User from "./components/RoleUser/UserHome";
// import NavBarSide from './components/SideBar/NavBarSide'
// import Root from "./Root";
// import history from "./history";

class App extends Component {
  render() {
    return (
        // <BrowserRouter>
        //     {/* <Router history = {history}> */}
        //   <div className="navi">{/* <Paperbase /> */}</div>
        //   <Container>
        //     <Navigation />
        //     {/* <NavBarSide /> */}
        //     {/* <Navi /> */}
        //     <Switch>
        //       <Route path="/" component={Root}>
        //         <Route path="/login" exact component={Home} />
        //         {/* <Route path="/" component={Home} exact /> */}
        //         <Route path="/Admin" component={Admin} exact />
        //         <Route path="/home-user" component={User} exact />
        //         <Route path="/users" component={UserPage} />
        //         <Route path="/create-user" component={CreateUserPage} />
        //         <Route path="/documents" component={Docs} />
        //         <Route path="/create-new-document" component={NewDocument} />
        //         <Route path="/types" component={Types} />
        //         <Route path="/groups" component={GroupPage} />
        //         <Route component={Error} />
        //       </Route>
        //     </Switch>
        //   </Container>
        // {/* </Router> */}
        // </BrowserRouter>
      <BrowserRouter>
        <div>
          <Paperbase />
          <Container>
            {/* <Navigation /> */}
            {/* <NavBarSide /> */}
            {/* <Navi /> */}
            <Switch>
              {/* <Route path="/login" exact component={Login} /> */}
              <Route path="/" component={Home} exact />
              <Route path="/home-admin" component={Admin} exact />
              <Route path="/home-user" component={User} exact />
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
