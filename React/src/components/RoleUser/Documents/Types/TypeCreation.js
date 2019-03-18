import React from "react";
import { Form, Input, FormGroup, FormText, Container, Button } from "reactstrap";
import { Jumbotron } from "reactstrap";
import axios from 'axios';


class TypeCreation extends React.Component {
  constructor(props) {
      super(props)
    this.toggle = this.toggle.bind(this);
      this.state = {
          title: '',
      }
  }
  toggle() {
    this.setState(prevState => ({
      dropdownOpen: !prevState.dropdownOpen
    }));
  }
// addNewType = (title) => {
//   axios.post("http://localhost:8081/api/documents/types", {
//     title, completed:false
//   })
//   .then(res=>this.setState({types:
//   [...this.state.types, res.data]}))
// }
//neveikia

  addNewType = e => {
    e.preventDefault();
    const newType = {
      title: this.state.title,
    }
    this.props.onTypeAdded(newType);
    axios.post("http://localhost:8081/api/documents/types", newType)
      .then(function (response) {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  onInputChange = event => {
    console.log(event.target.value);
    this.setState({ title: event.target.value })
  }

  render() {
    return (
      <div>
        <Container>
          <br />
          <Jumbotron>
            <h3>
              <b>Sukurti naują tipą</b>
            </h3>
            <Form onSubmit={this.addNewType}>
              <FormGroup>
                <Input type="text" name="title" id="titlet" placeholder="Pavadinimas" onChange={this.onInputChange} />
                <FormText>Nurodykite tipo pavadinimą</FormText>
              </FormGroup>
              <br />
              <Button type="submit" color="primary">Pridėti</Button>{" "}
            </Form>
          </Jumbotron>
        </Container>
      </div>
    );
  }
}

export default TypeCreation;
