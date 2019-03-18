import React, { Component } from "react";
import PropTypes from "prop-types";
import Type from "./Type";
// import { Table } from "reactstrap";

import { withStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";

import TableHead from "@material-ui/core/TableHead";

import Paper from "@material-ui/core/Paper";
import TablePagination from "@material-ui/core/TablePagination";
import TableRow from "@material-ui/core/TableRow";
import TablePaginationActionsWrapped from "../../../../helpers/TablePaginationActions";
import TableFooter from "@material-ui/core/TableFooter";
import TableCell from "@material-ui/core/TableCell";

const styles = theme => ({
  root: {
    width: "100%",
    marginTop: theme.spacing.unit * 3,
    overflowX: "auto"
  },
  table: {
    minWidth: 700
  }
});

class Types extends Component {
  render() {
    const { classes } = this.props;
    const { types, rowsPerPage, page } = this.props;
    const emptyRows =
      rowsPerPage - Math.min(rowsPerPage, types.length - page * rowsPerPage);
    return (
      <Paper className={classes.root}>
        <div className={classes.tableWrapper}>
          <Table className={classes.table}>
            <TableBody>
              {this.props.types
                .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                .map(type => (
                  <Type
                    onTypeDeleted={this.props.onTypeDeleted}
                    type={type}
                    //   a={console.log(group.id)} konsologingui
                    key={type.id}
                  />
                ))}
              {emptyRows > 0 && (
                <TableRow style={{ height: 48 * emptyRows }}>
                  <TableCell colSpan={6} />
                </TableRow>
              )}
            </TableBody>
            <TableFooter>
              <TableRow>
                <TablePagination
                  rowsPerPageOptions={[5, 10, 25]}
                  colSpan={3}
                  count={types.length}
                  rowsPerPage={rowsPerPage}
                  page={page}
                  SelectProps={{
                    native: true
                  }}
                  onChangePage={this.handleChangePage}
                  onChangeRowsPerPage={this.handleChangeRowsPerPage}
                  ActionsComponent={TablePaginationActionsWrapped}
                />
              </TableRow>
            </TableFooter>
          </Table>
        </div>
      </Paper>
    );
  }
}
Types.propTypes = {
  types: PropTypes.array.isRequired
};

export default withStyles(styles)(Types);

//     constructor() {
//         super();

//         this.handleChange = this.handleChange.bind(this);
//         this.handleSubmit = this.handleSubmit.bind(this);
//     }

//     handleChange(event) {
//         this.setState({ documentTypes: event.target.documentTypes });
//     }

//     handleSubmit(event) {
//         alert('The documentType you picked is: ' + this.state.documentTypes);
//         event.preventDefault();
//     }

//     render() {

//         const { documentTypes } = this.props;

//         return (
//             <div>
//                 <form onSubmit={this.handleSubmit}>
//                     <label>
//                         Dokumento tipas:
//                   <select value={documentTypes} onChange={this.handleChange}>
//                             {
//                                 (documentTypes && documentTypes.length > 0) && documentTypes.map((documentType) => {
//                                     return (
//                                         <option value="{documentType.title}">
//                                             {" "}
//                                             {
//                                                 documentType.data
//                                             }
//                                         </option>
//                                     );
//                                 })
//                             }
//                         </select>
//                     </label> <br />
//                 </form>
//             </div>
//         );
//     }
// }
