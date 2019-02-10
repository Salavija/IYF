package it.docSys.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.docSys.configs.States;
import it.docSys.services.DocumentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "Document Status Controller")
@RequestMapping(value = "/api/documents/states")
public class DocumentStatusController {

    @Autowired
    DocumentStatusService documentStatusService;

//    @Autowired
//    States states;

    @GetMapping(value = "/{states/Assign}")
    @ApiOperation(value = "Get document Status", notes = "Returns specific document Status")
    public States AssignStatus(
            @ApiParam(value = "state", required = true)
            @PathVariable final States states) {
//        logger.info("Specific document has been found");
        return documentStatusService.AssignStatusOfDocument(states);
    }

    @GetMapping(value = "/{states/update}")
    @ApiOperation(value = "Updates document Status", notes = "Updates specific document Status")
    public States UpdateStatus(
            @ApiParam(value = "state", required = true)
            @PathVariable final States states) {
//        logger.info("Specific document has been found");
        return documentStatusService.updateStatusOfDocument(states);
    }
}
