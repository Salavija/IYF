import React from 'react';
import {
    Form, Input, FormText, Container, Button
} from 'reactstrap';
import { Jumbotron } from 'reactstrap';

class TypeCreation extends React.Component {

    render() {
        return (
            <div>
                <Container>
                    <br></br>
                    <Jumbotron>
                        <h3>Sukurti naują dokumento tipą</h3>
                        <Form>  
                                <Input type="text" name="type" id="type" placeholder="Dokumento tipas" />
                                <FormText>Įveskite naują tipą</FormText>
                                <br></br>
                            <Button color="success">Pridėti</Button>{' '}
                        </Form>
                    </Jumbotron>
                </Container>
            </div>
        );
    };
}

export default TypeCreation;