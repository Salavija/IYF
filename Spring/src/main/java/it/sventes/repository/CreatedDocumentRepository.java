package it.sventes.repository;

import it.sventes.model.document.CreatedDocument;

public interface CreatedDocumentRepository {

    long create(CreatedDocument createdDocument);
    void update(long id, CreatedDocument createdDocument);
    void delete(long id);
}
