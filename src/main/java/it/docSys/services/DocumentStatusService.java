package it.docSys.services;

import it.docSys.configs.States;
import it.docSys.model.Document;
import it.docSys.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;

import static java.time.LocalDate.now;

@Service
public class DocumentStatusService {
    //TODO Begin with CreatedDocument conversion to SubmittedDocument Using States; Use minimum 2 Repos (if necessary
    // write my own methods) Use dates as a parameter to differ Status of Document; Create Switch based on States Enum;
    //TODO Use only Document model.Try to use LocalDate "now" (as imitation of button pushed to submit) assign/update status


    @Autowired
    private DocumentRepository documentRepository;

//    @Autowired
    Document document;

//    @Autowired
    States states;

    public DocumentStatusService(DocumentRepository documentRepository, Document document, States states) {
        this.documentRepository = documentRepository;
        this.document = document;
        this.states = states;
    }

    public DocumentStatusService() {
    }

    public LocalDate getTimeStamp() {

        return now(Clock.systemDefaultZone());
    }


    public States AssignStatusOfDocument(States state) {


//        if (coin == null) {
//            logger.warning("Coins must be Euros");
//            throw new IllegalArgumentException("Coins has to have a value");
//        }
        //TODO Maybe it needs null check to? Should I use id to assign status? Maybe no...

        switch (states) {
//            case SUKURTAS: {
//                if (document.getSubmissionDate() == null && document.getApprovingDate() == null && document.getRejectionDate() == null) {
//
//                    document.setState("Sukurtas");
//                    return document.getState();
//                    break;
//                }
//            }
            case PATEIKTAS: {
                if (document.getSubmissionDate() != null && document.getApprovingDate() == null && (document.getRejectionDate() == null)) {

                    document.setState(States.PATEIKTAS);
//                       return document.getState();
                    documentRepository.save(document);
                    break;
                }
            }
            case PRIIMTAS: {
                if (document.getSubmissionDate() == null && document.getApprovingDate() != null && (document.getRejectionDate() == null)) {

                    document.setState(States.PRIIMTAS);
//                        return document.getState();
                    documentRepository.save(document);
                    break;
                }
            }
            case ATMESTAS: {
                if (document.getSubmissionDate() == null && document.getApprovingDate() == null && (document.getRejectionDate() != null)) {

                    document.setState(States.ATMESTAS);
//                            return document.getState();
                    documentRepository.save(document);
                    break;
                }


            }

        }
        return document.getState();


    }

    public States updateStatusOfDocument(States state) {
        if (document.getSubmissionDate() != null) {
            document.setState(States.PATEIKTAS);
            documentRepository.save(document);

        } else if (document.getApprovingDate() != null) {
            document.setState(States.PRIIMTAS);
            documentRepository.save(document);

        } else if (document.getRejectionDate() != null) {
            document.setState(States.ATMESTAS);
            documentRepository.save(document);
        }
        return document.getState();
    }
}

