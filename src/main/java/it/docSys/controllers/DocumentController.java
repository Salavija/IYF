package it.docSys.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.docSys.DTO.GetDocumentDTO;
import it.docSys.DTO.PutDocumentDTO;
import it.docSys.services.impl.DocumentServiceImpl;
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
    private DocumentServiceImpl documentServiceImpl;

    public DocumentController(DocumentServiceImpl documentServiceImpl) {
        this.documentServiceImpl = documentServiceImpl;
    }


    private static Logger logger = LoggerFactory.getLogger(DocumentController.class);

    /*---Add new document---*/

    @PostMapping
    @ApiOperation(value = "Save new document", notes = "Creates new document and saves to database")
    public void save(@RequestBody final PutDocumentDTO putDocumentDTO){
        logger.info("A document has been created");
        documentServiceImpl.create(putDocumentDTO);
    }

    /*---Update existing document by id---*/

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing document")
    public void update(@PathVariable final Long id, @RequestBody PutDocumentDTO putDocumentDTO){
        logger.info("A document has been updated");
        documentServiceImpl.update(id, putDocumentDTO);
    }

    /*---get document by id---*/

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get document by id", notes = "Returns specific document by id")
    public GetDocumentDTO getById(
        @ApiParam(value = "id", required = true)
        @PathVariable final Long id) {
        logger.info("Specific document has been found");
        return documentServiceImpl.get(id);
    }

    /*---get all documents---*/

    @GetMapping
    @ApiOperation(value = "Get all documents", notes = "Returns all documents from database")
    public List<GetDocumentDTO> getAllDocuments(){
        logger.info("List of all documents");
        return documentServiceImpl.listAll();
    }

    /*---Delete a document by id---*/

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete document by id")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id){
        logger.info("A document has been deleted");
        documentServiceImpl.delete(id);
    }


//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    @ApiOperation(value="Create document",notes="Creates new document")
//    @ApiParam(value="id",required=true)
//    public void create(@RequestBody Document document) {
//        documentService.create(document);
//}



//    @PostMapping("/document")
//    public ResponseEntity<?> create(@RequestBody Document document) {
//        long id = documentService.create(document);
//        logger.info("A document has been created");
//        return ResponseEntity.ok().body("New Document has been saved with ID:" + id);
//
//    }

    /*---Get a document by id---*/

//    @GetMapping("/document/{id}")
//    public ResponseEntity<Document> get(@PathVariable("id") long id) {
//        Document doc = documentRepository.findById(id);
//        logger.info("Document has been found");
//        return ResponseEntity.ok().body();
//    }
//
//    @GetMapping("/{id}")
//    public Document getById(
//            @ApiParam(value = "id", required = true)
//            @PathVariable long id){
//        return documentService.get(id);
//    }
//
//    /*---get all documents---*/
//    @GetMapping("/document")
//    public ResponseEntity<List<Document>> list() {
//        List<Document> documents = documentService.list();
//        logger.info("List of all documents");
//        return ResponseEntity.ok().body(documents);
//    }
//
//    /*---Update a document by id---*/
//    @PutMapping("/document/{id}")
//    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Document document) {
//        Document doc =  documentService.get(id);
//        documentService.create(doc);
//        logger.info("A document has been updated");
//        return ResponseEntity.ok().body("Document has been updated successfully.");
//    }
//
//    /*---Delete a document by id---*/
//    @DeleteMapping("/document/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") long id) {
//        documentService.delete(id);
//        logger.info("A document has been deleted");
//        return ResponseEntity.ok().body("Document has been deleted successfully.");
//    }


}
