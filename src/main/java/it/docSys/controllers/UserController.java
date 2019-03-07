package it.docSys.controllers;

import it.docSys.entities.DocUser;
import it.docSys.security.SecurityService;
import it.docSys.security.UserServiceInt;
import it.docSys.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import it.docSys.DTO.*;
import it.docSys.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;

@RestController
@Api(value = "DocUser Controller")
@RequestMapping(value = "/api/docUsers")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserServiceInt userServiceInt;


    /* Start of Login Section not good */


//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new DocUser());
//
//        return "registration";
//    }

//    @PostMapping("/registration")
//    public String registration(@ModelAttribute("userForm") DocUser userForm, BindingResult bindingResult) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userServiceInt.save(userForm);
//
//        securityService.autoLogin(userForm.getUserName(), userForm.getPasswordConfirm());
//
//        return "redirect:/login";
//    }

//    @GetMapping("/login")
//    public String login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password are invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//    }

//    @GetMapping({"/", "/welcomeAdmin"})
//    public String welcomeAdmin(Model model) {
//        return "welcomeAdmin";
//    }
//
//    @GetMapping({"/", "/welcomeUser"})
//    public String welcomeUser(Model model) {
//        return "welcomeUser";
//    }

    /* End of Login Section */

    /* CRUD SECTION  */

    /*---Add new user---*/

    @PostMapping("/create")
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

    /*--Assign Document to User--*/

    @PutMapping("/user/{docId}/{userName}")
    @ApiOperation(value = "Assign document to user")
    public void assignDocumentToUser(@PathVariable final Long docId, @PathVariable final String userName) {
        userService.assignDocumentToUser(docId, userName);
    }

    /*Get Documents of this user*/

    @GetMapping("/user/{username}/documents")
    @ApiOperation(value = "Get all documents assigned to particular user")
    public List<TestDocDTO> userDocuments (@PathVariable final String username) {
        return userService.getUserDocuments(username);
    }


}