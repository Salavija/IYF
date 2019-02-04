import React from 'react';
import FormD from './FormD';
// import tableD from './Document';
import TypeCreation from './TypeCreation';
import Document from './Document';



class Docs extends React.Component {

  render() {
    return (
      <div>
        
        <FormD />
        <TypeCreation />
        <Document />
    </div>
    );
  };
}

export default Docs;