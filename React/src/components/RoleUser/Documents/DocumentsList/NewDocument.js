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
import {
  withRouter
} from 'react-router-dom'

class CreateNew extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      type: "",
      types: [],
      title: "",
      description: "",
      author: "",
      status: "SUKURTAS",
      approvingDate: null,
      dropdownOpen: false,
      rejectionDate: null,
      rejectionReason: "Labai reikejo",
      submissionDate: null,
      attachments: 1,
      userName:"Belekas"
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
      this.setState({ types: answer });
    });
  };

  addNewDocument = (e) => {
    e.preventDefault();
    const newDocument = {
      title: this.state.title,
      type: this.state.type,
      description: this.state.description,
      author: this.state.author,
      user_name:this.state.userName,
      state: this.state.status,
      approvingDate: this.state.approvingDate,
      dropdownOpen: this.state.dropdownOpen,
      rejection_date: this.state.rejectionDate,
      rejection_reason: this.state.rejectionReason,
      submission_date: this.state.submissionDate,
      attachments: this.state.attachments
    };
    
    axios
      .post("http://localhost:8081/api/documents", newDocument)
      .then(response => {
        console.log(response);
        this.props.history.push('/documents')
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

  onInputDescriptionChange = event => {
    this.setState({
      description: event.target.value
    });
  };

  onInputAuthorChange = event => {
    this.setState({
      author: event.target.value
    });
  };

  changeType = e => {
    let value = e.target.value;
    this.setState({ type: value });
  };

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
                    onChange={this.changeType}
                  >
                    {this.state.types.map(type => (
                      <option value={type.title}>{type.title}</option>
                    ))}
                  </Input>
                  <FormText>Nurodykite dokumento tipą</FormText>
                </FormGroup>

                <Dropdown isOpen={this.state.dropdownOpen} toggle={this.toggle}>
                  <DropdownToggle caret onChange={this.onInputTypeChange}>
                    Dokumento Tipas
                  </DropdownToggle>
                  <DropdownMenu>
                    {this.state.types.map(types => (
                      <DropdownItem>{types.title}</DropdownItem>
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
                  name="p"
                  id="p"
                  placeholder="Aprašymas"
                  onChange={this.onInputDescriptionChange}
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

export default withRouter(CreateNew);
