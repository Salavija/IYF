package it.docSys.services;


import it.docSys.DTO.GetDocumentDTO;
import it.docSys.DTO.PutDocumentDTO;
import it.docSys.model.Document;
import it.docSys.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;


    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Transactional
    public void create(PutDocumentDTO putDocumentDTO) {
    Document document = new Document();
    document.setAddressee(putDocumentDTO.getAddressee());
    document.setApprovingDate(putDocumentDTO.getApprovingDate());
    document.setAttachments(putDocumentDTO.getAttachments());
    document.setAuthor(putDocumentDTO.getAuthor());
    document.setDescription(putDocumentDTO.getDescription());
    document.setName(putDocumentDTO.getName());
    document.setRejectionDate(putDocumentDTO.getRejectionDate());
    document.setRejectionReason(putDocumentDTO.getRejectionReason());
    document.setSubmissionDate(putDocumentDTO.getSubmissionDate());
    document.setType(putDocumentDTO.getType());
    documentRepository.save(document);
    }


        @Transactional
        public GetDocumentDTO get(Long id) {
            Document document = documentRepository.findById(id).orElse(null);
            if (document != null) {
                return new GetDocumentDTO(document.getId(), document.getAuthor(), document.getType(),
                        document.getName(), document.getDescription(), document.getSubmissionDate(),
                        document.getApprovingDate(), document.getRejectionDate(), document.getAddressee(),
                        document.getRejectionReason(), document.getAttachments());
            }
            return null;
    }

    @Transactional
    public List<GetDocumentDTO> listAll() {
        return documentRepository.findAll().stream().map(document ->
                new GetDocumentDTO(document.getId(), document.getAuthor(), document.getType(),
                        document.getName(), document.getDescription(), document.getSubmissionDate(),
                        document.getApprovingDate(), document.getRejectionDate(), document.getAddressee(),
                        document.getRejectionReason(), document.getAttachments())).collect(Collectors.toList());
    }


    @Transactional
    public void update(long id, PutDocumentDTO putDocumentDTO) {
        Document document = documentRepository.findById(id).orElse(null);
        if (document != null){
//            document.setId(putDocumentDTO.getId());
            document.setAddressee(putDocumentDTO.getAddressee());
            document.setApprovingDate(putDocumentDTO.getApprovingDate());
            document.setAttachments(putDocumentDTO.getAttachments());
            document.setAuthor(putDocumentDTO.getAuthor());
            document.setDescription(putDocumentDTO.getDescription());
            document.setName(putDocumentDTO.getName());
            document.setRejectionDate(putDocumentDTO.getRejectionDate());
            document.setRejectionReason(putDocumentDTO.getRejectionReason());
            document.setSubmissionDate(putDocumentDTO.getSubmissionDate());
            document.setType(putDocumentDTO.getType());
        }
    }

    @Transactional
     public void delete(long id) {
    documentRepository.deleteById(id);
    }

}

