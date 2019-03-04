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
import FileUpl from "./FileUpl"
import TypesListGet from "../Types/TypesListGet"



class CreateNew extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      type: "",
      title: "",
      describtion: "",
      creationDate: "",
      dropdownOpen: false
    };
  }

  toggle() {
    this.setState(prevState => ({
      dropdownOpen: !prevState.dropdownOpen
      //gavimas praeito state
    }));
  }

  addNewDocument = () => {
    const newDocument = {
      title: this.state.title,
      author: this.state.author,
      type: this.state.type,
      describtion: this.state.describtion,
      creationDate: this.state.creationDate
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

  onInputChange = event => {
    console.log(event.target.value);
    this.setState({
      title: event.target.value,
      author: event.target.value,
      type: event.target.value,
      describtion: event.target.value,
      creationDate: event.target.value
    });
    //paemimas inputo ir idejimas i state
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
                <TypesListGet />
                <Dropdown isOpen={this.state.dropdownOpen} toggle={this.toggle}>
                  <DropdownToggle caret>Dokumento Tipas</DropdownToggle>
                  <DropdownMenu>
                    <DropdownItem>Sąskaita</DropdownItem>
                    <DropdownItem>Atostogų prašymas</DropdownItem>
                    <DropdownItem>Algos pakelimo prašymas</DropdownItem>
                  </DropdownMenu>
                </Dropdown>
              </FormGroup>
              <FormGroup>
                <Input
                  type="text"
                  name="title"
                  id="title"
                  placeholder="Dokumento pavadinimas"
                />
                <FormText>Nurodykite tikslų dokumento pavadinimą</FormText>
              </FormGroup>
              <FormGroup>
                <Input
                  type="textarea"
                  name="describtion"
                  id="describtion"
                  placeholder="Aprašymas"
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
