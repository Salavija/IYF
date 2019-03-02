import React from 'react';
// import tableD from './Document';
import TypeCreation from './TypeCreation'


class TypePage extends React.Component {
    // constructor(props) {
    //     super(props)
    //     this.state = {
    //         name: '',
    //         email: '',
    //         msg: ''
    //     }
    //     this.handleSubmit = this.handleSubmit.bind(this)
    // }


    // documentToDB() {
    //     axios
    //       .post("http://localhost:8081//api/documents")
    //       .then(response => {
    //           console.log(response)
    //       })
    //       .catch(error => console.log(error.response));
    // }
    render() {
        return (
            <div>

                <TypeCreation />
            </div>
        );
    };
}

export default TypePage;