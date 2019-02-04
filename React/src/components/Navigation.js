import React from "react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
} from 'reactstrap';

class Navigation extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false,
      dropdownOpen: false
    };
  }
  toggle() {
    this.setState({
      isOpen: !this.state.isOpen,
      dropdownOpen: !this.state.dropdownOpen
    });
  }

  render() {
  return (
    <div>

      <Navbar color="light" light expand="md">
        <NavbarBrand href="/">BDMS</NavbarBrand>
        <NavbarToggler onClick={this.toggle} />
        <Collapse isOpen={this.state.isOpen} navbar>
          <Nav className="ml-auto" navbar>
            <NavItem>
              <NavLink href="/">Prisijungti</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/about">Vartotojai</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/documents">Dokumentai</NavLink>
            </NavItem>

          </Nav>
        </Collapse>
      </Navbar>


      {/* <NavLink to="/">Home</NavLink>
      <NavLink to="/about">About</NavLink>
      <NavLink to="/Docs">Dokumentai</NavLink> */}
    </div>
  );
};
}

export default Navigation;