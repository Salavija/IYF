import React, { Component } from "react";
import PropTypes from "prop-types";
import Type from "./Type";
// import { Table } from "reactstrap";

import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';

import TableHead from '@material-ui/core/TableHead';

import Paper from '@material-ui/core/Paper';

const styles = theme => ({
    root: {
        width: '100%',
        marginTop: theme.spacing.unit * 3,
        overflowX: 'auto',
    },
    table: {
        minWidth: 700,
    },
});



class Types extends Component {
    
    render() {
        const { classes } = this.props;
        return (
            <Paper className={classes.root}>
                <Table className={classes.table}>
                <thead>
                    <tr>
                        <th>Pavadinimas</th>
                    </tr>
                </thead>
                <tbody>
                    {this.props.types.map(type => (
                        <Type
                            onTypeDeleted={this.props.onTypeDeleted}
                            type={type}
                            //   a={console.log(group.id)} konsologingui
                            key={type.id}
                        />
                    ))}
                </tbody>
            </Table>
            </Paper>
        );
    }
}
Types.propTypes = {
    types: PropTypes.array.isRequired
};

export default withStyles(styles) (Types);

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