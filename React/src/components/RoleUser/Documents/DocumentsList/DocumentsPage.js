import React from 'react';
import Document from './Document';
import EnchancedTable from './EnchancedTable';
import Documents from './Documents';
import CreateNew from './NewDocument';
// import DetailedList from './DetailedList'
import axios from "axios";

class DocumentPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            documents: []
        };
    }
    componentDidMount = () => {
        axios
            .get("http://localhost:8081/api/documents")
            .then(answer => {
                this.setState({ documents: answer.data });
            })
            .catch(error => {
                console.log(error);
            });
    };

    onGroupAdded = document => {
        this.setState({ documents: [...this.state.documents, document] });
    };

    onGroupDeleted = document => {
        this.setState(previousState => {
            return {
                documents: previousState.documents.filter(d => d.title !== document.title)
            };
        })
    }
    render() {
        return (
            <div>
                <CreateNew onDocumentAdded={this.onDocumentAdded}/>
                {/* <DetailedList /> */}
                <Documents documents={this.state.documents} onDocumentDeleted={this.onDocumentDeleted}/>
                <EnchancedTable />
            </div>
        );
    };
}

export default DocumentPage;