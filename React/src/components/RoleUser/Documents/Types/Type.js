import React from "react";
import PropTypes from "prop-types";
import axios from "axios";
import {
    Button
} from "reactstrap";

// import TableCell from '@material-ui/core/TableCell';
// import TableRow from '@material-ui/core/TableRow';

class Type extends React.Component {
    handleRemove = () => {
        this.props.onTypeDeleted(this.props.type);
        const url = "http://localhost:8081/api/documents/types" + this.props.type.title;
        axios
            .delete(url)
            .catch(err => {
                console.log(err);
            });
    };
    render() {
        return (
            <tr key={this.props.key}>
                <td>{this.props.type.title}</td>
                <Button type="submit" color="primary" onClick={this.handleRemove}>
                    Ištrinti
        </Button>
                {/* <button type="submit" onClick={e => this.editType(e, Type)}>
                  Redaguoti
                </button> */}
            </tr>
        );
    }
}
Type.Prototypes = {
    title: PropTypes.string.isRequired
    //kad mestu warningus
};

export default Type;
