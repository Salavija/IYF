import React from 'react';
import axios from "axios";
import TypeCreation from './TypeCreation'
import Types from './Types'


class TypePage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            types: []
        };
    }
    componentDidMount = () => {
        axios
            .get("http://localhost:8081/api/types")
            .then(answer => {
                this.setState({ types: answer.data });
            })
            .catch(error => {
                console.log(error);
            });
    };

    onTypeAdded = type => {
        this.setState({ types: [...this.state.types, type] });
    };

    onTypeDeleted = type => {
        this.setState(previousState => {
            return {
                types: previousState.types.filter(d => d.title !== type.title)
            };
        })
    }
    render() {
        console.log(this.state.types)
        return (
            <div>
                <TypeCreation onTypeAdded={this.onTypeAdded} />
                <Types types={this.state.types} onTypeDeleted={this.onTypeDeleted} />
            </div>
        );
    }
}

export default TypePage;
