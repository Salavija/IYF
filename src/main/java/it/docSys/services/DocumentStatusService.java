package it.docSys.services;

import it.docSys.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DocumentStatusService {
    //TODO Begin with CreatedDocument conversion to SubmittedDocument Using States; Use minimum 2 Repos (if necessary
    // write my own methods) Use dates as a parameter to differ Status of Document; Create Switch based on States Enum;
    //TODO Use only Document model.Try to use LocalDate "now" (as imitation of button pushed to submit)


    @Autowired
    private DocumentRepository documentRepository;



}
