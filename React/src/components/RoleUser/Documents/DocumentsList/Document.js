import React from 'react';
import { Table, Container, Row, Input } from 'reactstrap';
// import PropTypes from 'prop-types';
import axios from 'axios';
// import documents from './Documents';

class Document extends React.Component {
  handleRemove = () => {
    this.props.onDocumentDeleted(this.props.document);
    const url = "http://localhost:8081/api/documents/" + this.props.document.title;
    axios
      .delete(url)
      .catch(err => {
        console.log(err);
      });
  };
  render() {
    return (
      // <div>
                <tr key={this.props.key}>
                  <td>{this.props.author}</td>
                  <td>{this.props.title}</td>
                  <td>{this.props.type}</td>
                  <td>{this.props.description}</td>
                  <td>{this.props.creationDate}</td>
                <td>
            <button type="submit" onClick={this.handleRemove}>
              Ištrinti
        </button>
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