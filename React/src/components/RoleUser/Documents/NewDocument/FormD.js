import React from 'react';
import {
    Form, FormGroup, Input, FormText, Container, Button
} from 'reactstrap';
import { Dropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import { Jumbotron } from 'reactstrap';
import FileUpl from './FileUpl';
// import axios from 'axios';
import TypesListGet from './../Types/TypesListGet';
import axios from "axios";


class FormD extends React.Component {
    constructor(props) {
        super(props);

        this.toggle = this.toggle.bind(this);
        this.state = {
            type: "",
            title: "",
            describtion: "",
            dropdownOpen: false
        };
    }

    toggle() {
        this.setState(prevState => ({
            dropdownOpen: !prevState.dropdownOpen
        }));
    }

    onDocumentAdded = document => {
        this.setState({ documents: [...this.state.documents, document] });
    };

    addNewDocument = () => {
        const newDocument = {
            type: this.state.type,
            title: this.state.title,
            describtion: this.state.describtion,
        }
        this.props.onDocumentAdded(newDocument);
        axios.post("http://localhost:8081/api/documents", newDocument)
            .then(function (response) {
                console.log(response);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    onInputChange = (event) => {
        console.log(event.target.value);
        this.setState({ 
            type: event.target.value,
            title: event.target.value,
            describtion: event.target.value
         })
        //paemimas inputo ir idejimas i state
    }

    render() {
        return (
            <div>
                <Container>
                    <br></br>
                    <Jumbotron>
                        <h3><b>Dokumento kūrimo forma</b></h3>
                        <p className="lead"><i>Užpildykite visus laukus</i></p>

                        <Form onChange={this.onInputChange}>
                            <FormGroup>
                                <TypesListGet />
                                <Dropdown isOpen={this.state.dropdownOpen} toggle={this.toggle}>
                                    <DropdownToggle caret>
                                        Dokumento Tipas
        </DropdownToggle>
                                    <DropdownMenu>
                                        <DropdownItem>Sąskaita</DropdownItem>
                                        <DropdownItem>Atostogų prašymas</DropdownItem>
                                        <DropdownItem>Algos pakelimo prašymas</DropdownItem>
                                    </DropdownMenu>
                                </Dropdown>
                            </FormGroup>
                            <FormGroup>
                                <Input type="text" name="title" id="title" placeholder="Dokumento pavadinimas" />
                                <FormText>Nurodykite tikslų dokumento pavadinimą</FormText>
                            </FormGroup>
                            <FormGroup>
                                <Input type="textarea" name="describtion" id="describtion" placeholder="Aprašymas"  />
                                <FormText>Trumpas dokumento aprašymas</FormText>
                            </FormGroup>
                            <br></br>
                            <FileUpl />
                            <Button color="success" onClick={this.addNewDocument}>Pridėti</Button>{' '}
                        </Form>
                        
                    </Jumbotron>
                </Container>
            </div>
        );
    };
}

export default FormD;