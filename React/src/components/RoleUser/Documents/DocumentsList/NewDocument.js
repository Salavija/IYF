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
  Dropdown,
  Label
} from "reactstrap";
import { Jumbotron } from "reactstrap";
import axios from "axios";
import FileUpl from "./FileUpl";
// import TypesListGet from "../Types/TypesListGet";
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
      author:"",
      state: "SUKURTAS",
      approvingDate: null,
      dropdownOpen: false,
      rejectionDate: null,
      rejectionReason: "",
      submissionDate: null,
      addressee:"",
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
      author: this.state.author,
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


  onInputAuthorChange = event => {
    this.setState({
      author: event.target.value
    });
  };

  changeBackdrop(e) {
    let value = e.target.value;
    if (value !== 'static') {
      value = JSON.parse(value);
    }
    this.setState({ backdrop: value });
  }

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
                <FormGroup>
                  <Input 
                  type="select" 
                  name="backdrop" 
                  id="backdrop" 
                  placeholder="Dokumento tipas"
                  onChange={this.changeBackdrop}>
                    {this.state.types.map(types => (
                      <option value="true">{types.title}</option>
                    ))}

                  </Input>
                  <FormText>Nurodykite dokumento tipą</FormText>
                </FormGroup>

                <Dropdown isOpen={this.state.dropdownOpen} toggle={this.toggle}>
                  <DropdownToggle caret onChange={this.onInputTypeChange}>Dokumento Tipas</DropdownToggle>
                  <DropdownMenu>
                    {this.state.types.map(types => (
                      <DropdownItem >{types.title}</DropdownItem>
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
              <FormGroup>
                <Input
                  type="text"
                  name="author"
                  id="author"
                  placeholder="Autoriaus vardas"
                  onChange={this.onInputAuthorChange}
                />
                <FormText>Nurodykite autorių</FormText>
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
