package it.docSys.services;

import it.docSys.configs.States;
import it.docSys.model.Document;
import it.docSys.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;



public class DocumentStatusService {
    //TODO Begin with CreatedDocument conversion to SubmittedDocument Using States; Use minimum 2 Repos (if necessary
    // write my own methods) Use dates as a parameter to differ Status of Document; Create Switch based on States Enum;
    //TODO Use only Document model.Try to use LocalDate "now" (as imitation of button pushed to submit)


    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    Document document;


    public States StatusOfDocument(States states) {
//        if (coin == null) {
//            logger.warning("Coins must be Euros");
//            throw new IllegalArgumentException("Coins has to have a value");
//        }
        switch (states) {
            case SUKURTAS: {
                if (document.getSubmissionDate() == null && document.getApprovingDate() == null && document.getRejectionDate() == null) {

                    document.setState("Sukurtas");
                    break;
                }
            }
               case PATEIKTAS: {
                   if (document.getSubmissionDate() != null && document.getApprovingDate() == null && (document.getRejectionDate() == null)) {

                       document.setState("Pateiktas");
                       break;
                   }
               }
                case PRIIMTAS: {
                    if (document.getSubmissionDate() == null && document.getApprovingDate() != null && (document.getRejectionDate() == null)) {

                        document.setState("Priimtas");
                        break;
                    }
                }
            case ATMESTAS: {
                    if (document.getSubmissionDate() == null && document.getApprovingDate() == null && (document.getRejectionDate() != null)) {

                            document.setState("Atmestas");
                            break;
                        }


                    }
                } return states;
            }
        }

