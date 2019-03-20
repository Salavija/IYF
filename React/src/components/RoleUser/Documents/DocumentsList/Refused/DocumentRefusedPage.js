import React from "react";
import Documents from "./DocumentRefusedComponent";
import axios from "axios";
import DocumentsButtons from "../components/DocumentsButtons";

class DocumentRefusedPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            documents: [],
            page: 0,
            rowsPerPage: 5
        };
    }
    handleChangePage = (event, page) => {
        this.setState({ page });
    };

    downloadFile = (e) => {
        axios.get()

    }
    fileNameGetter = value => {
        let fileName = "";
        if (value && value.indexOf("attachment") !== -1) {
            let fileNameLink = /fileName[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
            let sameFile = fileNameLink.exec(value);
            if (sameFile != null && sameFile[1]) {
                fileName = sameFile[1].replace(/['"]/g, "");
            }
        }
        return fileName;
    }

    handleChangeRowsPerPage = event => {
        this.setState({ page: 0, rowsPerPage: event.target.value });
    };
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

    // onDocumentAdded = document => {
    //     this.setState({ documents: [...this.state.documents, document] });
    // };

    onDocumentDeleted = document => {
        this.setState(previousState => {
            return {
                documents: previousState.documents.filter(
                    d => d.title !== document.title
                )
            };
        });
    };
    render() {
        return (
            <div>
                <DocumentsButtons />
                <Documents
                    handleChangePage={this.handleChangePage}
                    handleChangeRowsPerPage={this.handleChangeRowsPerPage}
                    page={this.state.page}
                    rowsPerPage={this.state.rowsPerPage}
                    documents={this.state.documents}
                    onDocumentDeleted={this.onDocumentDeleted}
                    downloadFile={this.downloadFile}
                />
            </div>
        );
    }
}

export default DocumentRefusedPage;
