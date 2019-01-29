package it.sventes.services;

import it.sventes.model.document.Document;

import java.util.List;

public interface DocumentService {

    long create(Document document);
    Document get(long id);
    List<Document> list();
    void update(long id, Document document);
    void delete(long id);
}