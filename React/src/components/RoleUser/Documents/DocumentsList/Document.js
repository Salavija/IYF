import React from "react";
import { Table, Container, Row, Input } from "reactstrap";
// import PropTypes from 'prop-types';
import axios from "axios";
// import documents from './Documents';
import Button from "@material-ui/core/Button"

class Document extends React.Component {
  handleRemove = () => {
    this.props.onDocumentDeleted(this.props.document);
    const url =
      "http://localhost:8081/api/documents/" + this.props.document.title;
    axios.delete(url).catch(err => {
      console.log(err);
    });
  };
  handleSubmit = () => {
    this.props.onDocumentSubmitted(this.props.document);
    const url =
      "http://localhost:8081/api/documents/" + this.props.document.title;
    axios.delete(url).catch(err => {
      console.log(err);
    });
  };
  
  render() {
    return (
      // <div>
      <tr key={this.props.key}>
        {/* <td>{this.props.id}</td> */}
        <td>{this.props.author}</td>
        <td>{this.props.title}</td>
        <td>{this.props.type}</td>
        <td>{this.props.description}</td>
        <td>
          <Button type="submit" color="default" variant="contained" onClick={this.handleSubmit}>
            Pateikti
          </Button>
          <Button type="submit" color="secondary" variant="contained" onClick={this.handleRemove}>
            Ištrinti
          </Button>{' '}

          {/* <button
                  onClick={e => this.editDocument(e, document)}
                >
                  Redaguoti
                </button> */}
        </td>
        {/* </tr>
                <form>
                  <Input
                    type="textarea"
                    name="describtion"
                    id="describtion"
                    placeholder="Adresatas"
                  />
                  <button
                    onClick={e => this.sendDocument(e, document)}
                  >
                    Pateikti
                  </button>
                </form>
                </div> */}
      </tr>
    );
  }
}
// Document.Prototypes = {
//     id: PropTypes.string.isRequired,
//     author: PropTypes.string.isRequired,
//     title: PropTypes.string.isRequired,
//     type: PropTypes.string.isRequired,
//     describtion: PropTypes.string.isRequired,
// };

export default Document;
