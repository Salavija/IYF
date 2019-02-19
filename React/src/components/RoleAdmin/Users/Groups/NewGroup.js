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
      title: "", // pradinis 
      dropdownOpen: false
    };
  }

  toggle() {
    this.setState(prevState => ({
      dropdownOpen: !prevState.dropdownOpen
      //gavimas praeito state
    }));
  }

  addNewGroup = () =>  {
    const newGroup = {
      title: this.state.title,
    }
    this.props.onGroupAdded(newGroup);
    axios.post("http://localhost:8081/api/groups", newGroup)
    .then(function(response) {
      console.log(response);
    })
      .catch((error) => {
        console.log(error);
      });
  }

  onInputChange = (event) => {
    console.log(event.target.value);
    this.setState({title:event.target.value})
//paemimas inputo ir idejimas i state
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
                <Input type="text" name="title" id="title" placeholder="Pavadinimas" onChange ={this.onInputChange}/>
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
