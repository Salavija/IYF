package it.docSys.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.docSys.model.Document;
import it.docSys.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(value = "document")
@RequestMapping(value = "/documents")
public class DocumentController {

    @Autowired
    DocumentRepository documentRepository;

//    private ArrayList<Document> createdDocs = new ArrayList<>();
//    private ArrayList<Document> sentDocs = new ArrayList<>();
//    private ArrayList<Document> approvedDocs = new ArrayList<>();
//    private ArrayList<Document> rejectedDocs = new ArrayList<>();

    private static Logger logger = LoggerFactory.getLogger(DocumentController.class);

    /*---Add new document---*/

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Create document",notes="Creates new document")
    @ApiParam(value="id",required=true)
    public void create(@RequestBody Document document) {
        documentRepository.save(document);
}
//    @PostMapping("/document")
//    public ResponseEntity<?> create(@RequestBody Document document) {
//        long id = documentService.create(document);
//        logger.info("A document has been created");
//        return ResponseEntity.ok().body("New Document has been saved with ID:" + id);
//
//    }

    /*---Get a document by id---*/
    @GetMapping("/document/{id}")
    public ResponseEntity<Document> get(@PathVariable("id") long id) {
        Document document = documentRepository.getOne(id);
        logger.info("Document has been found");
        return ResponseEntity.ok().body(document);
    }

    /*---get all documents---*/
    @GetMapping("/document")
    public ResponseEntity<List<Document>> list() {
        List<Document> documents = documentRepository.findAll();
        logger.info("List of all documents");
        return ResponseEntity.ok().body(documents);
    }

    /*---Update a document by id---*/
    @PutMapping("/document/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Document document) {
        Document doc =  documentRepository.getOne(id);
        documentRepository.save(doc);
        logger.info("A document has been updated");
        return ResponseEntity.ok().body("Document has been updated successfully.");
    }

    /*---Delete a document by id---*/
    @DeleteMapping("/document/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        documentRepository.deleteById(id);
        logger.info("A document has been deleted");
        return ResponseEntity.ok().body("Document has been deleted successfully.");
    }




//    @Autowired
//    public DocumentController(DocumentService documentService) {
//        this.documentService = documentService;
//    }

//    @GetMapping("/documents/addDocument")
//    public ModelAndView createDocument(@PathVariable("createdDocument") Long id) {
//        documentService.findById(id).ifPresent(documentService::createNewDocument);
//        return createDocument(id);
//    }
//    @GetMapping("/document/addDocument/")
//    public ArrayList<Document> createDocument(@PathVariable("documentId") Long id) {
//        createdDocs.add(document);
//       //documentService.findById(id).(documentService::createNewDocument);
//       // documentService.findById(id).ifPresent(documentService::createNewDocument);
//        return createdDocs;
//    }

}