package it.docSys.controllers;

import it.docSys.model.CreatedDocument;
import it.docSys.services.CreatedDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreatedDocumentController {

    @Autowired
    CreatedDocumentService createdDocumentService;

    private static Logger logger = LoggerFactory.getLogger(CreatedDocumentController.class);

    /*---Add new createdDocument---*/
    @PostMapping("/createdDocument")
    public ResponseEntity<?> create(@RequestBody CreatedDocument createdDocument) {
        long id = createdDocumentService.create(createdDocument);
        logger.info("A createdDocument has been added");
        return ResponseEntity.ok().body("New CreatedDocument has been saved with ID:" + id);
    }

    /*---Update a createdDocument by id---*/
    @PutMapping("/createdDocument/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody CreatedDocument createdDocument) {
        createdDocumentService.update(id, createdDocument);
        logger.info("A createdDocument has been updated");
        return ResponseEntity.ok().body("CreatedDocument has been updated successfully.");
    }

    /*---Delete a document by id---*/
    @DeleteMapping("/createdDocument/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        createdDocumentService.delete(id);
        logger.info("A createdDocument has been deleted");
        return ResponseEntity.ok().body("CreatedDocument has been deleted successfully.");
    }

}