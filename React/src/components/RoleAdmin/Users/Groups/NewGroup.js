import React from "react";
import {
  Form,
  FormGroup,
  Input,
  FormText,
  Container,
  Button
} from "reactstrap";
import { Jumbotron } from "reactstrap";
import axios from "axios";


class NewGroup extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      title: "",
      dropdownOpen: false
    };
  }

  toggle() {
    this.setState(prevState => ({
      dropdownOpen: !prevState.dropdownOpen
    }));
  }

  addNewGroup() {
    axios.post("http://localhost:8081/api/groups", {
      title: this.state.title,
    })
    .then(function(response) {
      console.log(response);
    })
      .catch((error) => {
        console.log(error);
      });
  }

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
              <b>Sukurti naują grupę</b>
            </h3>
            <Form>
              <FormGroup>
                <Input type="text" name="title" id="title" placeholder="Pavadinimas" />
                <FormText>Nurodykite grupės pavadinimą</FormText>
              </FormGroup>
              <br />
              <Button onClick={this.addNewGroup} color="success">Pridėti</Button>{" "}
            </Form>
          </Jumbotron>
        </Container>
      </div>
    );
  }
}

export default NewGroup;
