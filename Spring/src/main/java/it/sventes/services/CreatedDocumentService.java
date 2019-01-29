package it.sventes.services;

import it.sventes.model.document.CreatedDocument;

public interface CreatedDocumentService {

    long create(CreatedDocument createdDocument);
    void update(long id, CreatedDocument createdDocument);
    void delete(long id);
}
