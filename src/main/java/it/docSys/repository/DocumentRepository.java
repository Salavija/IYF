package it.docSys.repository;

import it.docSys.configs.States;
import it.docSys.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


    @Transactional
    public interface DocumentRepository extends JpaRepository<Document, Long>, DocumentRepositoryCustom {

    }


