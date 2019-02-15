import React from 'react';
import {
    Form, FormGroup, Input, FormText, Container, Button
} from 'reactstrap';
import { Jumbotron } from 'reactstrap';
// import axios from 'axios';

class CreateUser extends React.Component {
    constructor(props) {
        super(props);

        this.toggle = this.toggle.bind(this);
        this.state = {
            dropdownOpen: false
        };
    }

    toggle() {
        this.setState(prevState => ({
            dropdownOpen: !prevState.dropdownOpen
        }));
    }

    render() {
        return (
            <div>
                <Container>
                    <br></br>
                    <Jumbotron>
                        <h3><b>Vartotojo kūrimo forma</b></h3>
                        <p className="lead"><i>Užpildykite visus laukus</i></p>

                        <Form>
                            <FormGroup>
                                <Input type="text" name="name" id="name" placeholder="Vardas" />
                                <FormText>Nurodykite asmens vardą</FormText>
                            </FormGroup>
                            <FormGroup>
                                <Input type="text" name="name" id="name" placeholder="Pavardė" />
                                <FormText>Nurodykite asmens pavardę</FormText>
                            </FormGroup>
                            <FormGroup>
                                <Input type="password" name="password" id="password" placeholder="********" />
                                <FormText>Nurodykite asmens slaptažodį</FormText>
                            </FormGroup>
                            <br></br>
                            <Button color="success">Pridėti</Button>{' '}
                        </Form>

                    </Jumbotron>
                </Container>
            </div>
        );
    };
}

export default CreateUser;