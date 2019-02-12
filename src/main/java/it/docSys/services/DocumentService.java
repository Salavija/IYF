package it.docSys.services;


import it.docSys.DTO.GetDocumentDTO;
import it.docSys.DTO.PutDocumentDTO;
import it.docSys.configs.States;
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
    document.setTitle(putDocumentDTO.getTitle());
    document.setRejectionDate(putDocumentDTO.getRejectionDate());
    document.setRejectionReason(putDocumentDTO.getRejectionReason());
    document.setSubmissionDate(putDocumentDTO.getSubmissionDate());
    document.setType(putDocumentDTO.getType());

        if (putDocumentDTO.getSubmissionDate() != null && putDocumentDTO.getApprovingDate() == null &&
                putDocumentDTO.getRejectionDate() == null && (putDocumentDTO.getRejectionReason() == null ||
                putDocumentDTO.getRejectionReason().equals(""))) {
            putDocumentDTO.setState(States.PATEIKTAS);

        } else if (putDocumentDTO.getApprovingDate() != null && putDocumentDTO.getSubmissionDate() == null &&
                putDocumentDTO.getRejectionDate() == null && (putDocumentDTO.getRejectionReason() == null ||
                putDocumentDTO.getRejectionReason().equals(""))) {
            putDocumentDTO.setState(States.PRIIMTAS);

        } else if (putDocumentDTO.getRejectionDate() != null || putDocumentDTO.getRejectionReason() != null &&
                (putDocumentDTO.getSubmissionDate() == null && putDocumentDTO.getApprovingDate() == null)) {
            putDocumentDTO.setState(States.ATMESTAS);

        } else if ((putDocumentDTO.getSubmissionDate() == null &&
                (putDocumentDTO.getApprovingDate() == null) && (putDocumentDTO.getRejectionDate() == null)
                && (putDocumentDTO.getRejectionReason() == null || putDocumentDTO.getRejectionReason().equals("")))) {

            putDocumentDTO.setState(States.SUKURTAS);
        }

        document.setState(putDocumentDTO.getState());


        documentRepository.save(document);
    }


        @Transactional
        public GetDocumentDTO get(Long id) {
            Document document = documentRepository.findById(id).orElse(null);
            if (document != null) {
                return new GetDocumentDTO(document.getId(), document.getAuthor(), document.getType(),
                        document.getTitle(), document.getDescription(), document.getSubmissionDate(),
                        document.getApprovingDate(), document.getRejectionDate(), document.getAddressee(),
                        document.getRejectionReason(), document.getAttachments(), document.getState());
            }
            return null;
    }

    @Transactional
    public List<GetDocumentDTO> listAll() {
        return documentRepository.findAll().stream().map(document ->
                new GetDocumentDTO(document.getId(), document.getAuthor(), document.getType(),
                        document.getTitle(), document.getDescription(), document.getSubmissionDate(),
                        document.getApprovingDate(), document.getRejectionDate(), document.getAddressee(),
                        document.getRejectionReason(), document.getAttachments(), document.getState())).collect(Collectors.toList());
    }


    @Transactional
    public void update(long id, PutDocumentDTO putDocumentDTO) {
        Document document = documentRepository.findById(id).orElse(null);
        if (document != null) {
//            document.setId(putDocumentDTO.getId());
            document.setAddressee(putDocumentDTO.getAddressee());
            document.setApprovingDate(putDocumentDTO.getApprovingDate());
            document.setAttachments(putDocumentDTO.getAttachments());
            document.setAuthor(putDocumentDTO.getAuthor());
            document.setDescription(putDocumentDTO.getDescription());
            document.setTitle(putDocumentDTO.getTitle());
            document.setRejectionDate(putDocumentDTO.getRejectionDate());
            document.setRejectionReason(putDocumentDTO.getRejectionReason());
            document.setSubmissionDate(putDocumentDTO.getSubmissionDate());
            document.setType(putDocumentDTO.getType());

            if (putDocumentDTO.getSubmissionDate() != null && putDocumentDTO.getApprovingDate() == null &&
                    putDocumentDTO.getRejectionDate() == null && (putDocumentDTO.getRejectionReason() == null ||
                    putDocumentDTO.getRejectionReason().equals(""))) {
                putDocumentDTO.setState(States.PATEIKTAS);

            } else if (putDocumentDTO.getApprovingDate() != null && putDocumentDTO.getSubmissionDate() == null &&
                    putDocumentDTO.getRejectionDate() == null && (putDocumentDTO.getRejectionReason() == null ||
                    putDocumentDTO.getRejectionReason().equals(""))) {
                putDocumentDTO.setState(States.PRIIMTAS);

            } else if (putDocumentDTO.getRejectionDate() != null || putDocumentDTO.getRejectionReason() != null)
//             !putDocumentDTO.getRejectionReason().isEmpty()) {
            {
                putDocumentDTO.setState(States.ATMESTAS);

            } else if ((putDocumentDTO.getSubmissionDate() == null &&
                    (putDocumentDTO.getApprovingDate() == null) && (putDocumentDTO.getRejectionDate() == null)
                    && (putDocumentDTO.getRejectionReason() == null || putDocumentDTO.getRejectionReason().equals("")))) {

                putDocumentDTO.setState(States.SUKURTAS);
            }

            document.setState(putDocumentDTO.getState());
        }
    }


//TODO CHECK for empty string is always failing and gives always true condition or NullPointer even on String WTF??
//TODO Switch just in case we need it
            //            switch (states) {
////
////                case PATEIKTAS: {
////                    if (document1.getSubmissionDate() != null && document1.getApprovingDate() == null && (document1.getRejectionDate() == null)) {
////
////                        document1.setState(States.PATEIKTAS);
//////                       return document.getState();
////                        documentRepository.save(document1);
////                        break;
////                    }
////                }
////                case PRIIMTAS: {
////                    if (document1.getSubmissionDate() == null && document1.getApprovingDate() != null && (document1.getRejectionDate() == null)) {
////
////                        document1.setState(States.PRIIMTAS);
//////                        return document.getState();
////                        documentRepository.save(document1);
////                        break;
////                    }
////                }
////                case ATMESTAS: {
////                    if (document1.getSubmissionDate() == null && document1.getApprovingDate() == null && (document1.getRejectionDate() != null)) {
////
////                        document1.setState(States.ATMESTAS);
//////                            return document.getState();
////                        documentRepository.save(document1);
////                        break;
////                    }
////
////
////                }
////                default:
////                    document1.setState(States.SUKURTAS);
////                    break;
////
////            }
////
////
////        }
////
////        return document;




    @Transactional
     public void delete(long id) {
    documentRepository.deleteById(id);
    }

}

