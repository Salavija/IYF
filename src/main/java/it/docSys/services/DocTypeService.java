package it.docSys.services;

import it.docSys.DTO.GetDocumentDTO;
import it.docSys.DTO.GroupGetDTO;
import it.docSys.entities.DocType;
import it.docSys.DTO.DocTypeGetDTO;
import it.docSys.DTO.DocTypePutDTO;
import it.docSys.entities.GroupEntity;
import it.docSys.repository.DocTypeRepo;
import it.docSys.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocTypeService { //TODO AR TURETU LEISTI IVESTI KELIS TOKIUS PAT DOKU TIPU PAVADINIMUS. NEMANAU. PAKLAUSTI PRODUCT OWNERIO PASKAICIUS REIKALAVIMUS.

    @Autowired
    private DocTypeRepo docTypeRepo; //ar ne geriau asigninti su autowired per kosntruktoriu?

    @Autowired
    private GroupRepo groupRepo;

    public DocTypeService(DocTypeRepo docTypeRepo, GroupRepo groupRepo) {
        this.docTypeRepo = docTypeRepo;
        this.groupRepo = groupRepo;
    }


    @Transactional(readOnly = true)
    public List<DocTypeGetDTO> getAllDocTypes () {
        return docTypeRepo.findAll().stream().map((doc) ->
                new DocTypeGetDTO (doc.getId(), doc.getTitle())).collect(Collectors.toList());

    }

    @Transactional
    public DocTypeGetDTO getById(Long id) {
        DocType docType = docTypeRepo.getOne(id);//.orElse(null);
        if (docType != null) {
            return new DocTypeGetDTO(docType.getId(), docType.getTitle());
        }
        return null;
    }



    @Transactional
    public void createDocType (DocTypePutDTO putDTO) {
        DocType docType = new DocType();
        docType.setTitle(putDTO.getTitle());
        docTypeRepo.save(docType);
    }


    @Transactional
    public void deleteDocType(String title) {
        docTypeRepo.deleteByTitle(title);

    }

    @Transactional
    public void updateDocType (String title, DocTypePutDTO putDTO) {
        if (docTypeRepo.existsByTitle(title)) {
            DocType docType = docTypeRepo.getByTitle(title);
            if (docType != null) {
                docType.setTitle(putDTO.getTitle());
            }
        } else return;
    }



    /*Dokumentu priskirtu konkreciam dokumento tipui suradimas*/

    @Transactional
    public List<GetDocumentDTO> getDocuments (String dt_title) {
        DocType docType = docTypeRepo.getByTitle(dt_title);
        if (docType != null) {
            return docType.getDocuments().stream().map(document ->
                    new GetDocumentDTO(document.getId(), document.getAuthor(), document.getType(), document.getTitle(),
                            document.getDescription(),
//                            document.getSubmissionDate(), document.getApprovingDate(),
//                            document.getRejectionDate(), document.getRejectionReason(),
                            document.getAttachments(),
                            document.getState())).collect(Collectors.toList());
        }
        return null;
    }


    /*Visu grupiu, kurioms priskirtas dokumento tipas, suradimas*/ /*title yra dokumento tipo pavadinimas*/

    @Transactional
    public List<GroupGetDTO> getGroupsOfDocType (String title) {
        DocType docType = docTypeRepo.getByTitle(title);
        if (docType != null) {
            return docType.getGroups().stream().map(group ->
                    new GroupGetDTO(group.getId(), group.getTitle())).collect(Collectors.toList());
        }
        return null;
    }


//    /*Grupes priskyrimas dokumento tipui (pagal id)*/
//
//    @Transactional //TODO
//    public void asignGroupToDocType (long docType_id, long group_id) {
//        GroupEntity group = groupRepo.findById(group_id);
//        DocType docType = docTypeRepo.findById(docType_id);
//        if (group != null) {
//            group.getDocTypes().add(docType);
//        }
//    }


    /*Grupes priskyrimas dokumento tipui (pagal title)*/

    @Transactional
    public void assignGroupToDocTypeByTitle (String dt_title, String g_title) {
        GroupEntity groupEntity = groupRepo.getByTitle(g_title);
        DocType docType = docTypeRepo.getByTitle(dt_title);
        if (groupEntity != null) {
            groupEntity.getDocTypes().add(docType);
        }
    }

    /*Grupes atskyrimas nuo dokumento tipo*/

    @Transactional
    public void deleteGroupFromDocType (String dt_title, String g_title) {
        GroupEntity groupEntity = groupRepo.getByTitle(g_title);
        DocType docType = docTypeRepo.getByTitle(dt_title);
        if (groupEntity != null) {
            groupEntity.getDocTypes().remove(docType);
        }
    }



}
