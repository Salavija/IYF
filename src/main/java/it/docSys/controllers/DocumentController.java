package it.docSys.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.docSys.DTO.DocStatusDTO;
import it.docSys.DTO.GetDocumentDTO;
import it.docSys.DTO.PutDocumentDTO;
import it.docSys.services.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(value = "Document Controller")
@RequestMapping(value = "/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }


    private static Logger logger = LoggerFactory.getLogger(DocumentController.class);

    /*---Add new document---*/

    @PostMapping
    @ApiOperation(value = "Save new document", notes = "Creates new document and saves to database")
    public void save(@RequestBody final PutDocumentDTO putDocumentDTO){
        logger.info("A document has been created");
        documentService.create(putDocumentDTO);
    }

    /*---Update existing document by id---*/

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing document")
    public void update(@PathVariable final Long id, @RequestBody PutDocumentDTO putDocumentDTO){
        logger.info("A document has been updated");
        documentService.update(id, putDocumentDTO);
    }

    /*---get document by id---*/

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get document by id", notes = "Returns specific document by id")
    public GetDocumentDTO getById(
            @ApiParam(value = "id", required = true)
            @PathVariable final Long id) {
        logger.info("Specific document has been found");
        return documentService.get(id);
    }

    /*---get all documents---*/

    @GetMapping
    @ApiOperation(value = "Get all documents", notes = "Returns all documents from database")
    public List<GetDocumentDTO> getAllDocuments(){
        logger.info("List of all documents");
        return documentService.listAll();
    }

    /*---Delete a document by id---*/

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete document by id")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id){
        logger.info("A document has been deleted");
        documentService.delete(id);
    }

    /*Dokumento tipo priskyrimas dokumentui*/
    @PutMapping("/{d_id}/{dt_title}")
    @ApiOperation(value = "Assign document type to a document")
    public void assignDocTypeToDocument(@PathVariable final Long d_id, @PathVariable final String dt_title) {
        documentService.assignDocTypeToDocument(d_id, dt_title);
    }
}