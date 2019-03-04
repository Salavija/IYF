import React from "react";
// import tableD from './Document';
import {
  Form,
  FormGroup,
  Input,
  FormText,
  Container,
  Button,
  DropdownItem,
  DropdownMenu,
  DropdownToggle,
  Dropdown
} from "reactstrap";
import { Jumbotron } from "reactstrap";
import axios from "axios";
import FileUpl from "./FileUpl";
import TypesListGet from "../Types/TypesListGet";
import fetchTypes from "../../../../helpers/fetchTypes";

class CreateNew extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      type:"",
      types: [],
      title: "",
      describtion: "",
      dropdownOpen: false
    };
  }

  toggle() {
    this.setState(prevState => ({
      dropdownOpen: !prevState.dropdownOpen
      //gavimas praeito state
    }));
  }

componentDidMount = () => {
  fetchTypes().then(answer => {
    this.setState({ types: answer.data });
  })
}

  addNewDocument = () => {
    const newDocument = {
      title: this.state.title,
      type: this.state.type,
      describtion: this.state.describtion,
    };
    this.props.onDocumentAdded(newDocument);
    axios
      .post("http://localhost:8081/api/documents", newDocument)
      .then(function(response) {
        console.log(response);
      })
      .catch(error => {
        console.log(error);
      });
  };

  onInputTitleChange = event => {
    this.setState({
      title: event.target.value
    });
  };

  onInputTypeChange = event => {
    this.setState({
      type: event.target.value
    });
  };

  onInputDescribtionChange = event => {
    this.setState({
      describtion: event.target.value
    });
  };

  // }
  // Groups.propTypes = {
  //   groups: PropTypes.array.isRequired
  // }

  render() {
    return (
      <div>
        <Container>
          <br />
          <Jumbotron>
            <h3>
              <b>Dokumento kūrimo forma</b>
            </h3>
            <p className="lead">
              <i>Užpildykite visus laukus</i>
            </p>

            <Form onSubmit={this.addNewDocument}>
              <FormGroup>
                <Dropdown isOpen={this.state.dropdownOpen} toggle={this.toggle}>
                  <DropdownToggle caret>Dokumento Tipas</DropdownToggle>
                  <DropdownMenu>
                    {this.state.types.map(type => (
                      <DropdownItem >{type.title}</DropdownItem>
                    ))}
                  </DropdownMenu>
                </Dropdown>
              </FormGroup>
              <FormGroup>
                <Input
                  type="text"
                  name="title"
                  id="title"
                  placeholder="Dokumento pavadinimas"
                  onChange={this.onInputTitleChange}
                />
                <FormText>Nurodykite tikslų dokumento pavadinimą</FormText>
              </FormGroup>
              <FormGroup>
                <Input
                  type="textarea"
                  name="describtion"
                  id="describtion"
                  placeholder="Aprašymas"
                  onChange={this.onInputDescribtionChange}
                />
                <FormText>Trumpas dokumento aprašymas</FormText>
              </FormGroup>
              <br />
              <FileUpl />
              <Button type="submit" color="primary">
                Pridėti
              </Button>{" "}
            </Form>
          </Jumbotron>
        </Container>
      </div>
    );
  }
}

export default CreateNew;
