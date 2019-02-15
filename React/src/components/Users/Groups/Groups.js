import React, { Component } from 'react';
import PropTypes from 'prop-types'
import axios from 'axios';
import Group from './Group';

class Groups extends Component {
    constructor(props) {
        super(props);
        this.state = {
            groups: props.groups
        }
    }
    render() {
        return (
            this.state.groups.map(group => (
                <li key={group.id} >
                    <Group title={group.title}
                        key={group.id} /></li>
            ))
        )
    }

    componentDidMount = () => {
        axios.get("http://localhost:8081/api/groups")
            .then((answer) => {
                this.setState({ groups: answer.data })
            })
            .catch((error) => {
                console.log(error)
            })

        // this.setState({ groups: { ... } })
    }

}
Groups.propTypes = {
    groups: PropTypes.array.isRequired
}
export default Groups;