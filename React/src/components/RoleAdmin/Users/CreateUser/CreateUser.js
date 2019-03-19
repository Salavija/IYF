import React from "react";
import { Form, FormGroup, Input, FormText, Container } from "reactstrap";
import axios from "axios";
import { Link } from "react-router-dom";
import Paper from "@material-ui/core/Paper";
import Button from "@material-ui/core/Button";

class CreateUser extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      first_name: "",
      last_name: "",
      email: "",
      password: "",
      dropdownOpen: false
    };
  }

  toggle() {
    this.setState(prevState => ({
      dropdownOpen: !prevState.dropdownOpen
    }));
  }

  handleClick(event) {
    var apiBaseUrl = "http://localhost:8081";
    var self = this;
    var payload = {
      email: this.state.username,
      password: this.state.password
    };
    axios
      .post(apiBaseUrl + "login", payload)
      .then(function(response) {
        console.log(response);
        if (response.data.code === 200) {
          console.log("Login successfull");
          var uploadScreen = [];
          // uploadScreen.push(<UploadScreen appContext={self.props.appContext} />)
          self.props.appContext.setState({
            loginPage: [],
            uploadScreen: uploadScreen
          });
        } else if (response.data.code === 204) {
          console.log("Username password do not match");
          alert("username password do not match");
        } else {
          console.log("Username does not exists");
          alert("Username does not exist");
        }
      })
      .catch(function(error) {
        console.log(error);
      });
  }

  render() {
    return (
      <div>
        <br />
        <Paper>
          <Container>
            <br />
            <h3>Vartotojo kūrimo forma</h3>
            <p className="lead">
              <i>Užpildykite visus laukus</i>
            </p>

            <Form>
              <FormGroup>
                <Input
                  type="text"
                  name="user_name"
                  id="user_name"
                  placeholder="Prisijungimo vardas"
                  onChange={(event, newValue) =>
                    this.setState({ user_name: newValue })
                  }
                />
                <FormText>Nurodykite asmens prisijungimo vardą</FormText>
              </FormGroup>
              <FormGroup>
                <Input
                  type="text"
                  name="first_name"
                  id="first_name"
                  placeholder="Vardas"
                  onChange={(event, newValue) =>
                    this.setState({ first_name: newValue })
                  }
                />
                <FormText>Nurodykite asmens vardą</FormText>
              </FormGroup>
              <FormGroup>
                <Input
                  type="text"
                  name="last_name"
                  id="last_name"
                  placeholder="Pavardė"
                  onChange={(event, newValue) =>
                    this.setState({ last_name: newValue })
                  }
                />
                <FormText>Nurodykite asmens pavardę</FormText>
              </FormGroup>
              <FormGroup>
                <Input
                  type="email"
                  name="email"
                  id="email"
                  placeholder="El. paštas"
                  onChange={(event, newValue) =>
                    this.setState({ email: newValue })
                  }
                />
                <FormText>Nurodykite elektroninį paštą</FormText>
              </FormGroup>
              <FormGroup>
                <Input
                  type="password"
                  name="password"
                  id="password"
                  placeholder="********"
                  onChange={(event, newValue) =>
                    this.setState({ password: newValue })
                  }
                />
                <FormText>Nurodykite asmens slaptažodį</FormText>
              </FormGroup>
              <br />
              <Button
                variant="contained"
                color="primary"
                primary={true}
                onClick={event => this.handleClick(event)}
              >
                Pridėti
              </Button>{" "}
              <Link to={"/users"}>
                <Button variant="contained" color="default">
                  Grįžti
                </Button>{" "}
              </Link>
            </Form>
            <br />
          </Container>
        </Paper>
      </div>
    );
  }
}

export default CreateUser;
