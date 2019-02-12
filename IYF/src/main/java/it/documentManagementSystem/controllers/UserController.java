package it.documentManagementSystem.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.docSys.DTO.GetDocumentDTO;
import it.docSys.DTO.PutDocumentDTO;
import it.documentManagementSystem.DTO.UserGetDTO;
import it.documentManagementSystem.DTO.UserPutDTO;
import it.documentManagementSystem.model.User;
import it.documentManagementSystem.services.UserServices;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServices userService;

         
    @GetMapping(value = "/{id}")
	@ApiOperation(value = "Get users by id")
	public UserGetDTO getById(
    @ApiParam(value = "id", required = true)
    @PathVariable final Long id) {
    logger.info("search user by id");
    return userService.findByUserId(id);
    }
    
    @GetMapping
    @ApiOperation(value = "Get all users")
    public List<UserGetDTO> findAllUser(){
        logger.info("List of all users");
        return userService.findAllUser();
    }
    
    @PostMapping
    @ApiOperation(value = "Create user")
    public void save(@RequestBody final UserPutDTO userPutDTO){
        logger.info("Created user");
        userService.createUser(userPutDTO);
    }
    
       
     @PutMapping("/{id}")
    @ApiOperation(value = "Update existing user")
     public void updateUser(@PathVariable final Long userId, @RequestBody UserPutDTO DTO){
         userService.updateUser(userId, DTO);
     }
    

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete user by id")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id){
        logger.info("User deleted");
        userService.deleteUser(id);   
    }
 }
    
    
    