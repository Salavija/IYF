package it.docSys.services;

import it.docSys.DTO.GroupGetDTO;
import it.docSys.model.DocType;
import it.docSys.DTO.DocTypeGetDTO;
import it.docSys.DTO.DocTypePutDTO;
import it.docSys.model.GroupEntity;
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
                new DocTypeGetDTO (doc.getTitle())).collect(Collectors.toList());

    }

    @Transactional
    public DocTypeGetDTO getById (Long id) {
        DocType docType = docTypeRepo.findById(id).orElse(null); //TODO ka sitas orElse null tiksliau duos? Ne visur yra Jpvz.
        if (docType != null) {
            return new DocTypeGetDTO(docType.getTitle());
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
        DocType docType = docTypeRepo.findByTitle(title);
        if (docType != null) {
            docType.setTitle(putDTO.getTitle());
        }
    } //TODO padaryti, kad mestu exception jei null ivestas ir pan!!!!!!!!!!!!!!!!!!!!!!!!


    /*Visu grupiu, kurioms priskirtas dokumento tipas, suradimas*/ /*title yra dokumento tipo pavadinimas*/
    @Transactional
    public  List<GroupGetDTO> getGroupsOfDocType (String title) {
        DocType docType = docTypeRepo.findByTitle(title);
        if (docType != null) {
            return docType.getGroups().stream().map(group ->
                    new GroupGetDTO(group.getTitle())).collect(Collectors.toList());
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
    public void  asignGroupToDocTypeByTitle (String dt_title, String g_title) {
        GroupEntity groupEntity = groupRepo.findByTitle(g_title);
        DocType docType = docTypeRepo.findByTitle(dt_title);
        if (groupEntity != null) {
            groupEntity.getDocTypes().add(docType);
        }
    }

    /*Grupes atskyrimas nuo dokumento tipo*/
    @Transactional
    public void deleteGroupFromDocType (String dt_title, String g_title) {
        GroupEntity groupEntity = groupRepo.findByTitle(g_title);
        DocType docType = docTypeRepo.findByTitle(dt_title);
        if (groupEntity != null) {
            groupEntity.getDocTypes().remove(docType);
        }
    }



}
