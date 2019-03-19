import React from "react";
import Documents from "./Documents";
import axios from "axios";
import Button from "@material-ui/core/Button";
import { Link } from "react-router-dom";

class DocumentPage extends React.Component {
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
        {/* <CreateNew onDocumentAdded={this.onDocumentAdded}/> */}
        {/* <DetailedList /> */}
        <br />
        <Button
          variant="contained"
          color="primary"
          component={Link}
          to="/create-new-document"
        >
          Kurti naują
        </Button>{" "}
        <br />
        <br />
        <Button
          variant="contained"
          color="default"
          component={Link}
          to="/create-new-document"
        >
          Pateikti dokumentai
        </Button>{" "}
        <Button
          variant="contained"
          color="primary"
          component={Link}
          to="/create-new-document"
        >
          Patvirtinti dokumentai
        </Button>{" "}
        <Button
          variant="contained"
          color="secondary"
          component={Link}
          to="/create-new-document"
        >
          Atmesti dokumentai
        </Button>{" "}
        <br />

        <Documents
          handleChangePage={this.handleChangePage}
          handleChangeRowsPerPage={this.handleChangeRowsPerPage}
          page={this.state.page}
          rowsPerPage={this.state.rowsPerPage}
          documents={this.state.documents}
          onDocumentDeleted={this.onDocumentDeleted}
        />
      </div>
    );
  }
}

export default DocumentPage;
