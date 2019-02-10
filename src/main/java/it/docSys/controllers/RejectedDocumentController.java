package it.docSys.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.docSys.DTO.*;
import it.docSys.services.RejectedDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(value = "Rejected Document Controller")
@RequestMapping(value = "/api/rejectedDocuments")
public class RejectedDocumentController {

    @Autowired
    private RejectedDocumentService rejectedDocumentService;

    public RejectedDocumentController(RejectedDocumentService rejectedDocumentService) {
        this.rejectedDocumentService = rejectedDocumentService;
    }


    private static Logger logger = LoggerFactory.getLogger(RejectedDocumentController.class);

    /*---Add new rejectedDocument---*/

    @PostMapping
    @ApiOperation(value = "Save new rejectedDocument", notes = "Adds new rejectedDocument and saves to database")
    public void save(@RequestBody final PutRejectedDocumentDTO putRejectedDocumentDTO){
        logger.info("A rejectedDocument has been added");
        rejectedDocumentService.create(putRejectedDocumentDTO);
    }

    /*---Update rejectedDocument by id---*/

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing rejectedDocument")
    public void update(@PathVariable final Long id, @RequestBody PutRejectedDocumentDTO putRejectedDocumentDTO){
        logger.info("A rejectedDocument has been updated");
        rejectedDocumentService.update(id, putRejectedDocumentDTO);
    }

    /*---get rejectedDocument by id---*/

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get rejectedDocument by id", notes = "Returns specific rejectedDocument by id")
    public GetRejectedDocumentDTO getById(
            @ApiParam(value = "id", required = true)
            @PathVariable final Long id) {
        logger.info("Specific rejectedDocument has been found");
        return rejectedDocumentService.get(id);
    }

    /*---get all rejectedDocument---*/

    @GetMapping
    @ApiOperation(value = "Get all rejectedDocuments", notes = "Returns all rejectedDocuments from database")
    public List<GetRejectedDocumentDTO> getAllRejectedDocuments(){
        logger.info("List of all rejectedDocuments");
        return rejectedDocumentService.listAll();
    }

    /*---Delete a rejectedDocument by id---*/

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete rejectedDocument by id")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id){
        logger.info("A rejectedDocument has been deleted");
        rejectedDocumentService.delete(id);
    }
}
