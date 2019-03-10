import React from "react";
import { Table, Container, Row } from "reactstrap";
import PropTypes from "prop-types";
import axios from "axios";
import Paper from '@material-ui/core/Paper';



class UsersList extends React.Component {
  getUsers() {
    axios
      .get("https://localhost:8081/api/users")
      .then(response =>
        response.data.results.map(user => ({
          firstName: ``,
          lastName: ``,
        }))
      )
      // Let's make sure to change the loading state to display the data
      .then(users => {
        this.setState({
          users,
          isLoading: false
        });
      })
      // We can still use the `.catch()` method since axios is promise-based“
      .catch(error => this.setState({ error, isLoading: false }));
  }
  render() {
    return (
      <div>
          <Row>
            <Table>
              <thead>
                <tr>
                <th>Prisijungimo vardas</th>
                  <th>Vardas</th>
                  <th>Pavardė</th>
                  <th>El. paštas</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                <td>{this.props.userName}</td>
                  <td>{this.props.firstName}</td>
                  <td>{this.props.lastName}</td>
                  <td>{this.props.email}</td>
                </tr>
                {/* <button
                  type="submit"
                  onClick={e => this.removeUser(e, user)}
                >
                  Ištrinti
                </button>
                <button
                  type="submit"
                  onClick={e => this.editUser(e, user)}
                >
                  Redaguoti
                </button> */}
              </tbody>
            </Table>
          </Row>
      </div>
    );
  }
}
UsersList.Prototypes = {
  firstName: PropTypes.string.isRequired,
  lastName: PropTypes.string.isRequired,
};

export default UsersList;


// import React from 'react';
// import PropTypes from 'prop-types';
// import AppBar from '@material-ui/core/AppBar';
// import Toolbar from '@material-ui/core/Toolbar';
// import Typography from '@material-ui/core/Typography';
// import Paper from '@material-ui/core/Paper';
// import Grid from '@material-ui/core/Grid';
// import Button from '@material-ui/core/Button';
// import TextField from '@material-ui/core/TextField';
// import Tooltip from '@material-ui/core/Tooltip';
// import IconButton from '@material-ui/core/IconButton';
// import { withStyles } from '@material-ui/core/styles';
// import SearchIcon from '@material-ui/icons/Search';
// import RefreshIcon from '@material-ui/icons/Refresh';
// import UserPage from '../RoleAdmin/Users/Users.js/UserPage';

// // import EnchancedTable from '../../Table/EnchancedTable';

// const styles = theme => ({
//   paper: {
//     maxWidth: 936,
//     margin: 'auto',
//     overflow: 'hidden',
//   },
//   searchBar: {
//     borderBottom: '1px solid rgba(0, 0, 0, 0.12)',
//   },
//   searchInput: {
//     fontSize: theme.typography.fontSize,
//   },
//   block: {
//     display: 'block',
//   },
//   addUser: {
//     marginRight: theme.spacing.unit,
//   },
//   contentWrapper: {
//     margin: '40px 16px',
//   },
// });

// function Content(props) {
//   const { classes } = props;

//   return (
//     <div>
//       <Paper className={classes.paper}>
//         <AppBar className={classes.searchBar} position="static" color="default" elevation={0}>
//           <Toolbar>
//             <Grid container spacing={16} alignItems="center">
//               <Grid item>
//                 <SearchIcon className={classes.block} color="inherit" />
//               </Grid>
//               <Grid item xs>
//                 <TextField
//                   fullWidth
//                   placeholder="Ieškoti pagal vardą arba pavardę"
//                   InputProps={{
//                     disableUnderline: true,
//                     className: classes.searchInput,
//                   }}
//                 />
//               </Grid>
//               <Grid item>
//                 <Button variant="contained" color="primary" className={classes.addUser}>
//                   Kurti naują vartotoją
//               </Button>
//                 <Tooltip title="Reload">
//                   <IconButton>
//                     <RefreshIcon className={classes.block} color="inherit" />
//                   </IconButton>
//                 </Tooltip>

//               </Grid>
//             </Grid>
//           </Toolbar>

//         </AppBar>
//         <div className={classes.contentWrapper}>
//           <Typography color="textSecondary" align="center">
//             Dar nėra vartotojų
//         </Typography>
//         </div>
//       </Paper>
//     </div>
//   );
// }

// Content.propTypes = {
//   classes: PropTypes.object.isRequired,
// };

// export default withStyles(styles)(Content);