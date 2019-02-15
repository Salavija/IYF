import { FilePond } from 'react-filepond';
import 'filepond/dist/filepond.min.css';
import React from 'react';

class FileUpl extends React.Component {
    render () {
    return(
        <FilePond allowMultiple={true} server="http://192.168.3.83:8081/" />
    );
};
}
export default FileUpl;