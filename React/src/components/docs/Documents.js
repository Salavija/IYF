import React from 'react';
import PropTypes from 'prop-types'
import axios from 'axios'

// class Documents extends Component {
//     constructor() {
//         super();
//     }
//     render() {
//         return (
//             function searchingFor(term) {
//                 return function (x) {
//                     return x.name.toLowerCase().includes(term.toLowerCase()) || !term;
//                 };
//             }
//         )
//     }
// }

const documents = (props) => {
    const documents=this.state.documents.map(document => {
            return (<div className="col-sm-4" key={document.id}>
                <tableD id={props.id}
                    author={props.author}
                    title={props.title}
                    type={props.type}
                    describtion={props.describtion}
                    key={props.id} />
            </div>);
        })
        return (<div className="container-fluid">
            <div className="row">
                {documents}
            </div>
        </div>);

    }
    // post

    componentDidMount = () => {
        axios.get("http://localhost:8081/documents")
            .then((answer) => {
                this.setState({ documents: answer.data })
            })
            .catch((error) => {
                console.log(error)
            })
    }

documents.propTypes = {
    documents: PropTypes.array.isRequired
}
export default documents;