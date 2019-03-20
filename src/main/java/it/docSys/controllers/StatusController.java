package it.docSys.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.docSys.DTO.statusDTO.*;
import it.docSys.services.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Document Status Controller")
@RequestMapping(value = "/api/documents/Status")
public class StatusController {


    @Autowired
    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    private static Logger logger = LoggerFactory.getLogger(DocumentController.class);

    //Get Document Status

    @GetMapping(value = "/GetStatus/{id}")
    @ApiOperation(value = "Get document status by id", notes = "Returns specific document status")
    public OnlyStatusDTO getStatusById(
            @ApiParam(value = "id", required = true)
            @PathVariable final Long id) {
        logger.info("Specific document Status exists");
        return statusService.getDocumentStatus(id);
    }

    //Submit Document

    @PutMapping("/submitted/{id}")
    @ApiOperation(value = "Submit document")
    public void submitDocumentById(@PathVariable final Long id, @RequestBody SubmitDTO submitDTO) {
        logger.info("A document has been submitted");
        statusService.submitDocument(id, submitDTO);
    }

    //Approve Document

    @PutMapping("/approved/{id}")
    @ApiOperation(value = "Approve document")
    public void approveDocumentById(@PathVariable final Long id, @RequestBody ApproveDTO approveDTO) {
        logger.info("A document has been approved");
        statusService.approveDocument(id, approveDTO);
    }

    //Reject Document

    @PutMapping("/rejected/{id}")
    @ApiOperation(value = "Reject document")
    public void rejectDocumentById(@PathVariable final Long id, @RequestBody RejectDTO rejectDTO) {
        logger.info("A document has been rejected");
        statusService.rejectDocument(id, rejectDTO);
    }
}
