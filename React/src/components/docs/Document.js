import React from 'react';
import { Table, Container,Row } from 'reactstrap';
import PropTypes from 'prop-types';

class Document extends React.Component {
    
render() {
    return (
        <div>
            <Container>
                <Row>
                    <Table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Autorius</th>
                                <th>Pavadinimas</th>
                                <th>Tipas</th>
                                <th>Aprašymas</th>
                                <th>Atmetimo priežastis</th>
                                <th>Patvirtinimo data</th>
                                <th>Pateikimo data</th>
                                <th>Adresatas</th>
                                <th>Pridėtukai</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{this.props.id}</td>
                                <td>{this.props.author}</td>
                                <td>{this.props.title}</td>
                                <td>{this.props.type}</td>
                                <td>{this.props.description}</td>
                            </tr>
                        </tbody>
                    </Table>
                </Row>
            </Container>
        </div>
    );
    };
    }
Document.Prototypes = {
    id: PropTypes.string.isRequired,
    author: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    type: PropTypes.string.isRequired,
    describtion: PropTypes.string.isRequired,
};

export default Document;

// author, title, type, describtion

// class t extends React.Component {
// // contructor(props){
// //     super(props);
// //     this.state={
// //         t
// //     }
// // }
//     render() {
//         return (
//             <div>
//                 <Container>
//                     <Row>
//                         <Table>
//                             <thead>
//                                 <tr>
//                                     <th>#</th>
//                                     <th>Autorius</th>
//                                     <th>Pavadinimas</th>
//                                     <th>Tipas</th>
//                                     <th>Aprašymas</th>
//                                 </tr>
//                             </thead>
//                             <tbody>
//                                 <tr>
//                                     <th scope="row">1</th>
//                                     <td>Mark</td>
//                                     <td>Otto</td>
//                                     <td>Otto</td>
//                                     <td>@mdo</td>
//                                 </tr>
//                                 <tr>
//                                     <th scope="row">2</th>
//                                     <td>Jacob</td>
//                                     <td>Thornton</td>
//                                     <td>Thornton</td>
//                                     <td>@fat</td>
//                                 </tr>
//                                 <tr>
//                                     <th scope="row">3</th>
//                                     <td>Larry</td>
//                                     <td>the Bird</td>
//                                     <td>the Bird</td>
//                                     <td>@twitter</td>
//                                 </tr>
//                             </tbody>
//                         </Table>
//                     </Row>
//                 </Container>
//             </div>
//         );
//     };
    
// }

// export default t;