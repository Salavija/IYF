package it.docSys.services;

import it.docSys.model.CreatedDocument;

public interface CreatedDocumentService {

    long create(CreatedDocument createdDocument);
    void update(long id, CreatedDocument createdDocument);
    void delete(long id);
}
