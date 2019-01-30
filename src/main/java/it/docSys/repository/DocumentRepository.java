package it.docSys.repository;

import it.docSys.model.Document;


import java.util.List;


    public interface DocumentRepository { //extends JpaRepository<Document, Long> {

        long create(Document document);
        Document get(long id);
        List<Document>list();
        void update(long id, Document document);
        void delete(long id);
    }


