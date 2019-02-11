package it.docSys.repository.Impl;


import it.docSys.configs.States;
import it.docSys.model.Document;
import it.docSys.repository.DocumentRepository;
import it.docSys.repository.DocumentRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDate;

import static java.time.LocalDate.now;

@Repository
@Transactional
public class DocumentRepositoryImpl implements DocumentRepositoryCustom {

    @Autowired
    DocumentRepository documentRepository;

    Document document;

    States states;

    @Override
    public LocalDate getTimeStamp() {

        return now(Clock.systemDefaultZone());
    }

    public States AssignStatusOfDocument(States state) {


//        if (states == null) {
//            logger.warning("Blah");
//            throw new IllegalArgumentException("Blah");
//        }
        //TODO Maybe it needs null check to? Should I use id to assign status? Maybe no... Should I use Some For/ForEach?

        switch (states) {

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
            default: document.setState(States.SUKURTAS);
                break;

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
