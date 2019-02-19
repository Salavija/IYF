import React from "react";
import { Form, Input, FormText, Container, Button } from "reactstrap";
import { Jumbotron } from "reactstrap";
import axios from 'axios';


class TypeCreation extends React.Component {
  // constructor(props) {
  //     super(props)
  //     this.state = {
  //         name: '',
  //         email: '',
  //         msg: ''
  //     }
  //     this.handleSubmit = this.handleSubmit.bind(this)
  // }

  // documentToDB() {
  //     axios
  //       .post("http://localhost:8081//api/documents")
  //       .then(response => {
  //           console.log(response)
  //       })
  //       .catch(error => console.log(error.response));
  // }
  typePost() {
    axios
        .post("http://localhost:8081/api/documents/types", {
        title: "",
      })
      .then(function(response) {
        console.log(response);
      })
      .catch(function(error) {
        console.log(error);
      });
  }

  render() {
    return (
      <div>
        <Container>
          <br />
          <Jumbotron>
            <h3>Sukurti naują dokumento tipą</h3>
            <Form>
              <Input
                type="text"
                name="type"
                id="type"
                placeholder="Dokumento tipas"
              />
              <FormText>Įveskite naują tipą</FormText>
              <br />
              <Button color="success">Pridėti</Button>{" "}
            </Form>
          </Jumbotron>
        </Container>
      </div>
    );
  }
}

export default TypeCreation;
