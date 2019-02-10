package it.docSys.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.docSys.DTO.DocTypeGetDTO;
import it.docSys.DTO.GroupGetDTO;
import it.docSys.DTO.GroupPutDTO;
import it.docSys.services.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Groups Controller")
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    private static Logger logger = LoggerFactory.getLogger(GroupController.class);


    /*Visu grupiu suradimas*/

    @GetMapping
    @ApiOperation(value = "Get all groups")
    public List<GroupGetDTO> getAllGroups () {
        logger.info("All groups were found and returned");
        return groupService.getAllGroups();
    }


    /*Grupes istrynimas*/

    @DeleteMapping("/{title}")
    @ApiOperation(value = "Delete group")
    public void deleteGroup(@PathVariable final String title) {
        groupService.deleteGroup(title);
        logger.info("GroupEntity {} was deleted", title);
    }


    /*Naujos grupes ivedimas*/

    @PostMapping
    @ApiOperation (value = "Add new group")
        public void saveGroup(@RequestBody final GroupPutDTO putDTO){
            logger.info("New group was created. New group is {}", putDTO.getTitle());
            groupService.saveGroup(putDTO);
    }


    /*Grupes atnaujinimas*/

    @PutMapping ("/{title}")
    @ApiOperation(value = "Update group")
    public void updateGroup(@PathVariable final String title, @RequestBody GroupPutDTO putDTO) {
        groupService.updateGroup(title, putDTO);
        logger.info("GroupEntity {} was updated", title);
    }


    /*Grupei priklausanciu dokumentu tipu suradimas*/ /* title yra grupes pavadinimas*/

    @GetMapping("/{title}/docTypes")
    @ApiOperation(value = "Get all document types of the group")
    public List<DocTypeGetDTO> docTypesOfGroup (@PathVariable final String title) {
        return groupService.getGroupDocTypes(title);
    }


}
