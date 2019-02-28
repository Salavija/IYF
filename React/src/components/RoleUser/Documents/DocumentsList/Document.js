import React from 'react';
import { Table, Container, Row, Input } from 'reactstrap';
import PropTypes from 'prop-types';
import axios from 'axios';
import documents from './DocumentsComponent';

class Document extends React.Component {
  handleRemove = document => {
    const url = "http://localhost:8081//api/documents/{id}";
    axios
      .delete(url)
      .then(res => {
        this.setState(previousState => {
          return {
            documents: previousState.documents.filter(
              d => d.id !== documents.id
            )
          };
        });
      })
      .catch(err => {
        console.log(err);
      });
  };
  handleRemoveE(event) {
    alert("Jūsų dokumentas " + this.state.title + " ištrintas");
    event.preventDefault();
  }

  removeDocument = (e, document) => {
    e.preventDefault();

    if (this.props.removeClick) {
      this.props.removeClick(document);
    }
  };
  render() {
    return (
      <div>
        <Container>
          <Row>
            <Table>
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Autorius</th>
                  <th>Pavadinimas</th>
                  <th>Tipas</th>
                  <th>Aprašymas</th>
                  {/* <th>Atmetimo priežastis</th>
                                <th>Patvirtinimo data</th>
                                <th>Pateikimo data</th>
                                <th>Adresatas</th>
                                <th>Pridėtukai</th> */}
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>{this.props.id}</td>
                  <td>{this.props.author}</td>
                  <td>{this.props.title}</td>
                  <td>{this.props.type}</td>
                  <td>{this.props.description}</td>
                </tr>
                <button
                  type="submit"
                  onClick={e => this.removeDocument(e, document)}
                >
                  Ištrinti
                </button>
                <button
                  type="submit"
                  onClick={e => this.editDocument(e, document)}
                >
                  Redaguoti
                </button>
                <form>
                  <Input
                    type="textarea"
                    name="describtion"
                    id="describtion"
                    placeholder="Adresatas"
                  />
                  <button
                    type="submit"
                    onClick={e => this.sendDocument(e, document)}
                  >
                    Siųsti
                  </button>
                </form>
              </tbody>
            </Table>
          </Row>
        </Container>
      </div>
    );
  }
}
Document.Prototypes = {
    id: PropTypes.string.isRequired,
    author: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    type: PropTypes.string.isRequired,
    describtion: PropTypes.string.isRequired,
};

export default Document;