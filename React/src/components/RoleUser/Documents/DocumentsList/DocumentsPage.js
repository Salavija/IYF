import React from 'react';
import Document from './Document';
import EnchancedTable from './EnchancedTable';
import Documents from './Documents';
import CreateNew from './NewDocument';
// import DetailedList from './DetailedList'
import axios from "axios";
import Button from '@material-ui/core/Button';
import { Link } from 'react-router-dom'

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
                {/* <CreateNew onDocumentAdded={this.onDocumentAdded}/> */}
                {/* <DetailedList /> */}
                <br></br>
                <Button variant="contained" color="primary" component={Link} to="/create-new-document" >
                   Kurti naują
                </Button>{' '}
                <hr></hr>
                <Button variant="contained" color="default" component={Link} to="/create-new-document" >
                    Pateikti dokumentai
                </Button>{' '}
                <Button variant="contained" color="primary" component={Link} to="/create-new-document" >
                    Patvirtinti dokumentai
                </Button>{' '}
                <Button variant="contained" color="secondary" component={Link} to="/create-new-document" >
                    Atmesti dokumentai
                </Button>{' '}

                <br></br>
                <EnchancedTable />
                <hr></hr>
                <Documents documents={this.state.documents} onDocumentDeleted={this.onDocumentDeleted} />

            </div>
        );
    };
}

export default DocumentPage;