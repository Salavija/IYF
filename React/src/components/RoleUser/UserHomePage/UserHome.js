// import React from 'react';
// import { Link } from "react-router-dom";
// import { Button, Form } from 'reactstrap';

// const headingP = <h3>Welcome Peasant!</h3>;
// const actionsP = <h5>Choose the action</h5>;
// const style = { margin: '20px', textAlign: 'center' };

// export default class UserHome extends React.Component {

//     render() {
//         return (
//             <Form>
//                 <div style={style}>
//                     {headingP}
//                     {actionsP}
//                     <Link to={"/create-new-document"}>
//                         <Button outline color="success">Sukurti dokumenta</Button>{' '}
//                     </Link>
//                     <Link to={"./Documents/DocumentEdit/DocEdition.js"}>
//                         <Button outline color="primary">Taisyti dokumenta</Button>{' '}
//                     </Link>
//                     <Button outline color="secondary">Trinti dokumenta</Button>{' '}
//                     <Button outline color="info">Perziuret visus dokus</Button>{' '}
//                     <Button outline color="warning">Perziureti konkretu dokumenta</Button>{' '}
//                     <Button outline color="danger">Pateikti dokumenta</Button>
//                 </div>

            
//         );
//     }
// }


import React from "react";
import PropTypes from "prop-types";
// react plugin for creating charts
import ChartistGraph from "react-chartist";
// @material-ui/core
import withStyles from "@material-ui/core/styles/withStyles";
import Icon from "@material-ui/core/Icon";
// @material-ui/icons
import Store from "@material-ui/icons/Store";
import Warning from "@material-ui/icons/Warning";
import DateRange from "@material-ui/icons/DateRange";
import LocalOffer from "@material-ui/icons/LocalOffer";
import Update from "@material-ui/icons/Update";
import ArrowUpward from "@material-ui/icons/ArrowUpward";
import AccessTime from "@material-ui/icons/AccessTime";
import Accessibility from "@material-ui/icons/Accessibility";
import BugReport from "@material-ui/icons/BugReport";
import Code from "@material-ui/icons/Code";
import Cloud from "@material-ui/icons/Cloud";
// core components
import GridItem from "components/Grid/GridItem.jsx";
import GridContainer from "components/Grid/GridContainer.jsx";
import Table from "components/Table/Table.jsx";
import Card from "components/Card/Card.jsx";
import CardHeader from "components/Card/CardHeader.jsx";
import CardBody from "components/Card/CardBody.jsx";
import CardFooter from "components/Card/CardFooter.jsx";

import { bugs, website, server } from "variables/general.jsx";

import {
    dailySalesChart,
    emailsSubscriptionChart,
    completedTasksChart
} from "variables/charts.jsx";

import dashboardStyle from "assets/jss/material-dashboard-react/views/dashboardStyle.jsx";

class UserHome extends React.Component {
    state = {
        value: 0
    };
    handleChange = (event, value) => {
        this.setState({ value });
    };

    handleChangeIndex = index => {
        this.setState({ value: index });
    };
    render() {
        const { classes } = this.props;
        return (
            <div>
                <GridContainer>
                    <GridItem xs={12} sm={12} md={4}>
                        <Card chart>
                            <CardHeader color="success">
                                <ChartistGraph
                                    className="ct-chart"
                                    data={dailySalesChart.data}
                                    type="Line"
                                    options={dailySalesChart.options}
                                    listener={dailySalesChart.animation}
                                />
                            </CardHeader>
                            <CardBody>
                                <h4 className={classes.cardTitle}>Daily Sales</h4>
                                <p className={classes.cardCategory}>
                                    <span className={classes.successText}>
                                        <ArrowUpward className={classes.upArrowCardCategory} /> 55%
                  </span>{" "}
                                    increase in today sales.
                </p>
                            </CardBody>
                            <CardFooter chart>
                                <div className={classes.stats}>
                                    <AccessTime /> updated 4 minutes ago
                </div>
                            </CardFooter>
                        </Card>
                    </GridItem>
                    <GridItem xs={12} sm={12} md={4}>
                        <Card chart>
                            <CardHeader color="warning">
                                <ChartistGraph
                                    className="ct-chart"
                                    data={emailsSubscriptionChart.data}
                                    type="Bar"
                                    options={emailsSubscriptionChart.options}
                                    responsiveOptions={emailsSubscriptionChart.responsiveOptions}
                                    listener={emailsSubscriptionChart.animation}
                                />
                            </CardHeader>
                            <CardBody>
                                <h4 className={classes.cardTitle}>Email Subscriptions</h4>
                                <p className={classes.cardCategory}>
                                    Last Campaign Performance
                </p>
                            </CardBody>
                            <CardFooter chart>
                                <div className={classes.stats}>
                                    <AccessTime /> campaign sent 2 days ago
                </div>
                            </CardFooter>
                        </Card>
                    </GridItem>
                    <GridItem xs={12} sm={12} md={4}>
                        <Card chart>
                            <CardHeader color="danger">
                                <ChartistGraph
                                    className="ct-chart"
                                    data={completedTasksChart.data}
                                    type="Line"
                                    options={completedTasksChart.options}
                                    listener={completedTasksChart.animation}
                                />
                            </CardHeader>
                            <CardBody>
                                <h4 className={classes.cardTitle}>Completed Tasks</h4>
                                <p className={classes.cardCategory}>
                                    Last Campaign Performance
                </p>
                            </CardBody>
                            <CardFooter chart>
                                <div className={classes.stats}>
                                    <AccessTime /> campaign sent 2 days ago
                </div>
                            </CardFooter>
                        </Card>
                    </GridItem>
                </GridContainer>
                    <GridItem xs={12} sm={12} md={6}>
                        <Card>
                            <CardHeader color="warning">
                                <h4 className={classes.cardTitleWhite}>Employees Stats</h4>
                                <p className={classes.cardCategoryWhite}>
                                    New employees on 15th September, 2016
                </p>
                            </CardHeader>
                            <CardBody>
                                <Table
                                    tableHeaderColor="warning"
                                    tableHead={["ID", "Name", "Salary", "Country"]}
                                    tableData={[
                                        ["1", "Dakota Rice", "$36,738", "Niger"],
                                        ["2", "Minerva Hooper", "$23,789", "Curaçao"],
                                        ["3", "Sage Rodriguez", "$56,142", "Netherlands"],
                                        ["4", "Philip Chaney", "$38,735", "Korea, South"]
                                    ]}
                                />
                            </CardBody>
                        </Card>
                    </GridItem>
                </GridContainer>
            </div>
        );
    }
}

UserHome.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(dashboardStyle)(UserHome);