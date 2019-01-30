package it.docSys.repository;

import it.docSys.model.CreatedDocument;

public interface CreatedDocumentRepository {

    long create(CreatedDocument createdDocument);
    void update(long id, CreatedDocument createdDocument);
    void delete(long id);
}
