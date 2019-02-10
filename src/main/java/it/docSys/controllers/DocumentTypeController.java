package it.docSys.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.docSys.DTO.DocTypeGetDTO;
import it.docSys.DTO.DocTypePutDTO;
import it.docSys.services.DocTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


@RestController
@ApiIgnore
@Api(value = "Document Type Controller")
@RequestMapping(value = "/api/documents/types")
public class DocumentTypeController {

    @Autowired
    private DocTypeService docTypeServ; //pas Juliu per laukus suautowirinta. Kur geriau ir kada kaip??????

    public DocumentTypeController(DocTypeService docTypeServ) {
        this.docTypeServ = docTypeServ;
    }

    private static Logger logger = LoggerFactory.getLogger(DocumentTypeController.class);


    /*Visu dokumentu tipu suradimas*/

    @GetMapping
    @ApiOperation(value = "Get all documentType types")
    public List<DocTypeGetDTO> getAllDocTypes () {
        logger.info("All existing types of documents were found and returned");
        return docTypeServ.getAllDocTypes();
    }


    /*Naumo dokumento tipo ivedimas*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new document type")
    public void saveDocType (@ApiParam(value="Doc type data", required = true)
                                 @RequestBody final DocTypePutDTO putDTO) {
        docTypeServ.createDocType(putDTO);
        logger.info("New type of document was created. New type is {}", putDTO.getTitle());
    }


    /*Dokumento tipo istrynimas*/

    @DeleteMapping("/{title}")
    @ApiOperation(value ="Delete documentType type")
    public void deleteDocType(@PathVariable final String title) {
        docTypeServ.deleteDocType(title);
        logger.info("Document type {} was deleted", title);
    }


    /*Dokumento tipo atnaujinimas/keitimas*/
    @PutMapping ("/{title}")
    @ApiOperation(value = "Update documentType type")
    public void updateDocType (@PathVariable final String title, @RequestBody DocTypePutDTO putDTO) {
        docTypeServ.updateDocType(title, putDTO);
        logger.info("Document type {} was updated", title);
    }


}
