package it.docSys.repository;

import it.docSys.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


    @Transactional
    public interface DocumentRepository extends JpaRepository<Document, Long> {
    }

