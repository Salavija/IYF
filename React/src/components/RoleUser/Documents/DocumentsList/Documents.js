import React, { Component } from 'react';
import PropTypes from 'prop-types'
// import axios from 'axios';
import Document from './Document';
import { Table } from "reactstrap";

class Documents extends Component {
    // constructor(props) {
    //     super(props);
    //     this.state = {
    //         documents: props.documents
    //     }
    // }
    // componentDidMount = () => {
    //     axios.get("http://localhost:8081/api/documents")
    //         .then((answer) => {
    //             this.setState({ documents: answer.data })
    //         })
    //         .catch((error) => {
    //             console.log(error)
    //         })
    // }
    render() {
        return (
            <Table bordered>
                <thead>
                    <tr>
                        {/* <th>ID</th> */}
                        <th>Autorius</th>
                        <th>Pavadinimas</th>
                        <th>Tipas</th>
                        <th>Aprašymas</th>
                        <th>Būsena</th>
                        <th>Veiksmai</th>

                        {/* <th>Atmetimo priežastis</th>
                                <th>Patvirtinimo data</th>
                                <th>Pateikimo data</th>
                                <th>Adresatas</th>
                                <th>Pridėtukai</th> */}
                    </tr>
                </thead>
                <tbody>
            {this.props.documents.map(document => (
                    <Document 
                    onDocumentDeleted={this.props.onDocumentDeleted}
                    onDocumentSubmitted={this.props.onDocumentSubmitted}
                    document={document}
                        author={document.author}
                        type={document.type}
                        title={document.title}
                        description={document.description}
                        status={document.status}
                    // creationDate={document.creationDate}
                        key={document.id} />
            ))}
            </tbody>
            </Table>
        )
    } 
}
Documents.propTypes = {
    documents: PropTypes.array.isRequired
}
export default Documents;
