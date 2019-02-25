import React, { Component } from "react";
import PropTypes from "prop-types";
import Type from "./Type";
import { Table } from "reactstrap";

class Types extends React.Component {
    render() {
        return (
            <Table>
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
        );
    }
}
Types.propTypes = {
    types: PropTypes.array.isRequired
};

export default Types;

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