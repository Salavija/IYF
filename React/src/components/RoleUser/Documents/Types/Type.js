import React from "react";
import PropTypes from "prop-types";
import axios from "axios";

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
                <button type="submit" onClick={this.handleRemove}>
                    Ištrinti
        </button>
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
