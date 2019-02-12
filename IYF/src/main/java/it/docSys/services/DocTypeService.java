package it.docSys.services;

import it.docSys.model.DocType;
import it.docSys.DTO.DocTypeGetDTO;
import it.docSys.DTO.DocTypePutDTO;
import it.docSys.repository.DocTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocTypeService { //AR TURETU LEISTI IVESTI KELIS TOKIUS PAT DOKU TIPU PAVADINIMUS. NEMANAU. PAKLAUSTI PRODUCT OWNERIO PASKAICIUS REIKALAVIMUS.

    @Autowired
    private DocTypeRepo docTypeRepo; //ar servise pas mane nebuvo kontruktoriaus, kur repo asignina???????????

    public DocTypeService(DocTypeRepo docTypeRepo) {
        this.docTypeRepo = docTypeRepo;
    }

    //dokumentu tipu nuskaitymas
    @Transactional(readOnly = true) //ar read only yra pas Juliu???? NERA
    public List<DocTypeGetDTO> getAllDocTypes () {
        return docTypeRepo.findAll().stream().map((doc) ->
                new DocTypeGetDTO (doc.getTitle())).collect(Collectors.toList());

    } //pas juliu get/put DTO yra kurie apraso doko duomenis grazinamo.


    //naujo dokumento tipo kurimas
//    @Transactional
//    public void createNewDocType (String title) {
//        DocType newDocType = new DocType(title);
//        docTypeRepo.save(newDocType);
//    }
//KURIS BUDAS IS DVIEJU TEISINGESNIS.
    @Transactional
    public void createDocType (DocTypePutDTO putDTO) { //cia siulo keisti i Stringa lempute controleryje.
        DocType docType = new DocType();
        docType.setTitle(putDTO.getTitle()); //iDTO pakeisti.
        docTypeRepo.save(docType);
    }


    //dokumento tipo istrynimas +
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
    } //padaryti, kad mestu exception jei null ivestas ir pan!!!!!!!!!!!!!!!!!!!!!!!!


}
