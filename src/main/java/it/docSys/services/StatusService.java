package it.docSys.services;

import it.docSys.DTO.DocStatusDTO;
import it.docSys.DTO.GetDocumentDTO;
import it.docSys.DTO.OnlyStatusDTO;
import it.docSys.entities.Document;
import it.docSys.enums.States;
import it.docSys.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class StatusService {


        @Autowired
        private DocumentRepository documentRepository;

    public StatusService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Transactional
    public void changeAnyDocStatus(long id, DocStatusDTO docStatusDTO) {
        Document document = documentRepository.getOne(id);
        if (document != null) {
            document.setApprovingDate(docStatusDTO.getApprovingDate());
            document.setRejectionDate(docStatusDTO.getRejectionDate());
            document.setRejectionReason(docStatusDTO.getRejectionReason());
            document.setSubmissionDate(docStatusDTO.getSubmissionDate());

            if (docStatusDTO.getSubmissionDate().equals("")) {
                docStatusDTO.setSubmissionDate(LocalDate.of(0000, 00, 00));
            }else if (docStatusDTO.getApprovingDate().equals("")) {
                docStatusDTO.setApprovingDate(LocalDate.of(0000, 00, 00));
            }else if (docStatusDTO.getRejectionDate().equals("")) {
                docStatusDTO.setRejectionDate(LocalDate.of(0000, 00, 00));
            }


            if (docStatusDTO.getSubmissionDate() != null && docStatusDTO.getApprovingDate() == null &&
                    docStatusDTO.getRejectionDate() == null && (docStatusDTO.getRejectionReason() == null ||
                    docStatusDTO.getRejectionReason().equals("")) && !docStatusDTO.getSubmissionDate().
                    equals(LocalDate.of(0000, 00, 00)) && docStatusDTO.getApprovingDate().
                    equals(LocalDate.of(0000, 00, 00)) && docStatusDTO.getRejectionReason().
                    equals(LocalDate.of(0000, 00, 00))) {
                docStatusDTO.setState(States.PATEIKTAS);

            } else if (docStatusDTO.getApprovingDate() != null && docStatusDTO.getSubmissionDate() == null &&
                    docStatusDTO.getRejectionDate() == null && (docStatusDTO.getRejectionReason() == null ||
                    docStatusDTO.getRejectionReason().equals("")) && docStatusDTO.getSubmissionDate().
                    equals(LocalDate.of(0000, 00, 00)) && !docStatusDTO.getApprovingDate().
                    equals(LocalDate.of(0000, 00, 00)) && docStatusDTO.getRejectionReason().
                    equals(LocalDate.of(0000, 00, 00))) {
                docStatusDTO.setState(States.PRIIMTAS);

            } else if (docStatusDTO.getRejectionDate() != null || docStatusDTO.getRejectionReason() != null ||
                    !docStatusDTO.getRejectionReason().equals("") &&
                    docStatusDTO.getSubmissionDate() == null && docStatusDTO.getApprovingDate() == null &&
                    docStatusDTO.getSubmissionDate().equals(LocalDate.of(0000, 00, 00))
                    && docStatusDTO.getApprovingDate().equals(LocalDate.of(0000, 00, 00))
                    && !docStatusDTO.getRejectionReason().equals(LocalDate.of(0000, 00, 00))
            ) {
                docStatusDTO.setState(States.ATMESTAS);

            } else if((docStatusDTO.getSubmissionDate() == null &&
                    (docStatusDTO.getApprovingDate() == null) && (docStatusDTO.getRejectionDate() == null)
                    && (docStatusDTO.getRejectionReason() == null || docStatusDTO.getRejectionReason().equals("")) &&
                    docStatusDTO.getSubmissionDate().equals(LocalDate.of(0000, 00, 00))
                    && docStatusDTO.getApprovingDate().equals(LocalDate.of(0000, 00, 00))
                    && docStatusDTO.getRejectionReason().equals(LocalDate.of(0000, 00, 00)))) {

                docStatusDTO.setState(States.SUKURTAS);
            }

            document.setState(docStatusDTO.getState());


            documentRepository.save(document);
        }
    }


    @Transactional
    public OnlyStatusDTO getDocumentStatus (Long id) {
        Document document = documentRepository.getOne(id);
        if (document != null) {
            return new OnlyStatusDTO(document.getState());
        }
        return null;
    }

    @Transactional
    public void submitDocument(long id, DocStatusDTO docStatusDTO) {
        Document document = documentRepository.getOne(id);
        if (document != null) {
            docStatusDTO.setSubmissionDate(LocalDate.now());
            docStatusDTO.setState(States.PATEIKTAS);
            document.setState(docStatusDTO.getState());
        }
        documentRepository.save(document);
    }
    @Transactional
    public void approveDocument(long id, DocStatusDTO docStatusDTO) {
        Document document = documentRepository.getOne(id);
        if (document != null) {
            docStatusDTO.setApprovingDate(LocalDate.now());
            docStatusDTO.setState(States.PRIIMTAS);
            document.setState(docStatusDTO.getState());
        }
        documentRepository.save(document);
    }
    @Transactional
    public void rejectDocument(long id, DocStatusDTO docStatusDTO) {
        Document document = documentRepository.getOne(id);
        if (document != null) {
            docStatusDTO.setRejectionDate(LocalDate.now());
            docStatusDTO.setRejectionReason("Įveskite atmetimo priežastį");
            docStatusDTO.setState(States.ATMESTAS);
            document.setState(docStatusDTO.getState());
        }
        documentRepository.save(document);
    }

    }
