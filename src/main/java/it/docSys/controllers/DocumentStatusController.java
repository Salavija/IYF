package it.docSys.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.docSys.DTO.GetDocumentDTO;
import it.docSys.configs.States;
import it.docSys.services.DocumentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class DocumentStatusController {

    @Autowired
    DocumentStatusService documentStatusService;

    @Autowired
    States states;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get document Status by id", notes = "Returns specific document Status by id")
    public GetDocumentDTO getStatusById(
            @ApiParam(value = "id", required = true)
            @PathVariable final Long id) {
//        logger.info("Specific document has been found");
        return documentStatusService.StatusOfDocument(states);
    }
}
