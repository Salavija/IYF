package it.docSys.controllers;

import io.swagger.annotations.Api;
import it.docSys.DTO.GroupGetDTO;
import it.docSys.DTO.UserGetDTO;
import it.docSys.DTO.UserPutDTO;
import it.docSys.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;

@RestController
@Api(value = "User Controller")
@RequestMapping(value = "/api/users")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /*---Add new user---*/

    @PostMapping
    @ApiOperation(value = "Save new user", notes = "Creates new user and saves to database")
    public void save(@RequestBody final UserPutDTO userPutDTO){
        logger.info("A user has been created");
        userService.createUser(userPutDTO);
    }

    /*---Update existing user by userId---*/

    @PutMapping("/update/{userId}")
    @ApiOperation(value = "Update existing user")
    public void update(@PathVariable final Long userId, @RequestBody UserPutDTO userPutDTO){
        logger.info("A user has been updated");
        userService.updateUser(userId, userPutDTO);
    }

    /*---get user by id---*/

    @GetMapping(value = "/get/{userId}")
    @ApiOperation(value = "Get user by id", notes = "Returns specific user by id")
    public UserGetDTO getById(
            @ApiParam(value = "userId", required = true)
            @PathVariable final Long userId) {
        logger.info("Specific user has been found");
        return userService.get(userId);
    }

    /*---get all users---*/

    @GetMapping
    @ApiOperation(value = "Get all users", notes = "Returns all users from database")
    public List<UserGetDTO> getAllDocuments(){
        logger.info("List of all users");
        return userService.findAllUser();
    }

    /*---Delete a user by id---*/

    @DeleteMapping("/delete/{userId}")
    @ApiOperation(value = "Delete user by id")
    public void delete(@ApiParam(value = "userId", required = true) @PathVariable final Long userId){
        logger.info("A user has been deleted");
        userService.deleteUser(userId);
    }

    /*--Assign User to Group--*/

    @PutMapping("/{groupId}/{docUserId}")
    @ApiOperation(value = "Assign user to group")
    public void assignUserToGroup(@PathVariable final Long groupId, @PathVariable final Long docUserId) {
        userService.assignUserToGroup(docUserId, groupId);
    }

    /*Get Groups of this user*/

    @GetMapping("/{username}/groups")
    @ApiOperation(value = "Get all groups assigned to particular user")
    public List<GroupGetDTO> userGroups (@PathVariable final String username) {
        return userService.getUserGroups(username);
    }

//    @GetMapping(value = "/{userName}")
//    @ApiOperation(value = "Get user groups", notes = "Returns specific user groups")
//    public List<GroupGetDTO> getByUserName(
//            @ApiParam(value = "userName", required = true)
//            @PathVariable final String userName) {
//        logger.info("Specific user groups has been found");
//        return userService.getUserGroups(userName);
//    }



//    @GetMapping(value = "/{id}")
//    @ApiOperation(value = "Get users by id")
//    public UserGetDTO getById(
//            @ApiParam(value = "id", required = true)
//            @PathVariable final Long userId) {
//        logger.info("search user by id");
//        return userService.findByUserId(userId);
//    }
//
//    @GetMapping
//    @ApiOperation(value = "Get all users")
//    public List<UserGetDTO> findAllUser(){
//        logger.info("List of all users");
//        return userService.findAllUser();
//    }
//
//    @PostMapping
//    @ApiOperation(value = "Create user")
//    public void save(@RequestBody final UserPutDTO userPutDTO){
//        logger.info("Created user");
//        userService.createUser(userPutDTO);
//    }
//
//
//    @PutMapping("/{id}")
//    @ApiOperation(value = "Update existing user")
//    public void updateUser(@PathVariable final Long userId, @RequestBody UserPutDTO DTO){
//        userService.updateUser(userId, DTO);
//    }
//
//
//    @DeleteMapping("/{id}")
//    @ApiOperation(value = "Delete user by id")
//    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id){
//        logger.info("User deleted");
//        userService.deleteUser(id);
//    }
}