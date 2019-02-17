package it.docSys.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.docSys.DTO.DocTypeGetDTO;
import it.docSys.DTO.DocTypePutDTO;
import it.docSys.DTO.GetDocumentDTO;
import it.docSys.DTO.GroupGetDTO;
import it.docSys.services.DocTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
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

    /*Dokumento tipo pagal id suradimas*/

    //Trying to change mapping to avoid: Ambiguous handler methods mapped for '/api/documents/types/33

    @GetMapping("/api/documents/types/{id}")
    @ApiOperation(value = "Get document type by id")
    public DocTypeGetDTO getById (
            @ApiParam(value = "id", required = true)
            @PathVariable long id) { //KADA REIKALINGAS FINAL PRIE PATH VARIABLE????????
        return docTypeServ.getById(id);
    }


    /*Naujo dokumento tipo ivedimas*/

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

    /*Dokumentu priskirtu konkreciam dokumento tipui suradimas*/
    @GetMapping("/{dt_title}")
    @ApiOperation(value = "Gets all documents assigned to particular document type")
    public List<GetDocumentDTO> documents (@PathVariable final String dt_title) {
        return docTypeServ.getDocuments(dt_title);
    }


    /*Grupiu, kurioms priklauso konkretus dokumento tipas(by doc title), suradimas*/

    @GetMapping("/{title}/groups")
    @ApiOperation(value = "Get all groups assigned to a particular document type")
    public List<GroupGetDTO> docGroups (@PathVariable final String title) {
        return docTypeServ.getGroupsOfDocType(title);
    }


//    /*Grupiu dokumento tipui priskyrimas (pagal id)*/
//
//    @PutMapping ("/{docType_id}/{group_id}") //TODO sutikrinti ar tikrai taip pavadinimai ir su kuo jie turi sutapti (pagal Juliu).
//    @ApiOperation(value = "Add a group to a document type")
//    public void asignGroupToDocType(@PathVariable final long docType_id, @PathVariable final long group_id) {
//        docTypeServ.asignGroupToDocType (docType_id, group_id);
//    }

    /*Grupiu priskyrimas dokumento tipui (pagal title)*/

    @PutMapping ("/{dt_title}/{g_title}")
    @ApiOperation(value = "Assign group to a document type")
    public void asignGroupToDocTypeByTitle(@PathVariable final String dt_title, @PathVariable final String g_title) {
        docTypeServ.asignGroupToDocTypeByTitle(dt_title, g_title);
    }


    /*Grupes atskyrimas nuo dokumento tipo*/
    @DeleteMapping("/{dt_title}/{g_title}")
    @ApiOperation(value = "Remove group from document type")
    public void deleteGroupFromDocType (@PathVariable final String dt_title, @PathVariable final String g_title) {
        docTypeServ.deleteGroupFromDocType(dt_title, g_title);
    }



//    @DeleteMapping("/{title}")
//    @ApiOperation(value ="Delete documentType type")
//    public void deleteDocType(@PathVariable final String title) {
//        docTypeServ.deleteDocType(title);
//        logger.info("Document type {} was deleted", title);
//    }


}
