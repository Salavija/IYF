package it.docSys.services;

import it.docSys.model.DocType;
import it.docSys.DTO.DocTypeGetDTO;
import it.docSys.DTO.DocTypePutDTO;
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


}
