package it.docSys.repository;

import it.docSys.model.DocType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocTypeRepo extends JpaRepository<DocType, Long> {
    DocType findByTitle(String title);
    void deleteByTitle(String title);

    }
