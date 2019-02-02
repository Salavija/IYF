package it.docSys.services.impl;


import it.docSys.DTO.DocumentDTO;
import it.docSys.model.Document;
import it.docSys.repository.DocumentRepository;
import it.docSys.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

//TODO Finish Conversion of Entities to DTO and make CRUD Work!

@Service
@Transactional(readOnly = true)
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;


    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    @Transactional
    @Override
    public DocumentDTO create(DocumentDTO documentDTO) {
        Document document;
        return documentRepository.save(document);
    }

//    @Override
//    public Document get(long id) {
//        return documentRepository.getOne(id);
//    }

        @Transactional
        @Override
        public DocumentDTO get(Long id) {
            Document document = documentRepository.findById(id).orElse(null);
            if (document != null) {
                return new DocumentDTO(document.getId(), document.getAuthor(), document.getType(),
                        document.getName(), document.getDescription(), document.getSubmissionDate(),
                        document.getApprovingDate(), document.getRejectionDate(), document.getAddressee(),
                        document.getRejectionReason(), document.getAttachments());
            }
            return null;
    }

    @Override
    public List<DocumentDTO> listAll() {
        return documentRepository.findAll().stream().map(document ->
                new DocumentDTO(document.getId(), document.getAuthor(), document.getType(),
                        document.getName(), document.getDescription(), document.getSubmissionDate(),
                        document.getApprovingDate(), document.getRejectionDate(), document.getAddressee(),
                        document.getRejectionReason(), document.getAttachments())).collect(Collectors.toList());
    }

//    @Transactional
//    @Override
//    public void update(long id, Document document) {
//        Document doc =  documentRepository.getOne(id);
//        documentRepository.save(doc);
//    }

    @Transactional
    @Override
    public void update(long id, Document document) {
        Document document1 = documentRepository.findById(id).orElse(null);
        if (document1 != null){
            document1.setId(document.getId());
            document1.setAddressee(document.getAddressee());
            document1.setApprovingDate(document.getApprovingDate());
            document1.setAttachments(document.getAttachments());
            document1.setAuthor(document.getAuthor());
            document1.setDescription(document.getDescription());
            document1.setName(document.getName());
            document1.setRejectionDate(document.getRejectionDate());
            document1.setRejectionReason(document.getRejectionReason());
            document1.setSubmissionDate(document.getSubmissionDate());
            document1.setType(document.getType());
        }
    }

    @Transactional
    @Override
    public void delete(long id) {
    documentRepository.deleteById(id);
    }

}

