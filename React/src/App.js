import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import Home from "./components/Home";
import About from "./components/About";
import Error from "./components/Error";
import Navigation from "./components/Navigation";
import Docs from './components/docs/DocsPage';
// import Paperbase from './components/Header/Paperbase';
import Navi from './components/Navi';

import { Container} from 'reactstrap';

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
            <Route path="/about" component={About} />
            <Route path="/documents" component={Docs} />
            <Route component={Error} />
          </Switch>
          </Container>
        </div>
      </BrowserRouter>
    );
  }
};

export default App; 