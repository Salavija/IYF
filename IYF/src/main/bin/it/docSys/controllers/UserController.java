package it.sventes.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    @ApiOperation(value = "Get all users")
    public List<UsersDTO> getUsers() {
        return userService.findAll();
    }

    @RequestMapping(path = "/users/createUser/{userId}", method = RequestMethod.POST)
    @ApiOperation(value = "Create user")
    public void newUser((@PathVariable final String userId, @RequestBody UserDTO DTO){
        userService.newUser(userId, DTO);
    }

    @RequestMapping(path = "/users/updateUser/{userId}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update userService")
    public void updateUser((@PathVariable final String userId, @RequestBody UserDTO DTO){
        userService.updateUser(userId, DTO);
    }

    @RequestMapping(path = "/users/deleteUser/{userId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "DELETE userService")
    public void deleteUser((@PathVariable final String userId, @RequestBody UserDTO DTO){
        userService.deleteUser(userId, DTO);
    }
  }
