import React, { Component } from 'react';
import PropTypes from 'prop-types'
import axios from 'axios';
import Document from './Document';

class Documents extends Component {
    constructor(props) {
        super(props);
        this.state = {
            documents: props.documents
        }
    }
    render() {
        return (
            this.state.documents.map(document => (
                <li key={document.id} >
                    <Document id={document.id}
                        author={document.author}
                        type={document.type}
                        title={document.title}
                        describtion={document.description}
                        key={document.id} /></li>
            ))
        )
    } 

componentDidMount = () => {
    axios.get("http://localhost:8081/api/documents")
        .then((answer) => {
            this.setState({ documents: answer.data })
        })
        .catch((error) => {
            console.log(error)
        })

    // this.setState({ documents: { ... } })
}

}
Documents.propTypes = {
    documents: PropTypes.array.isRequired
}
export default Documents;