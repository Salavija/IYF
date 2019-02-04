package it.docSys.repository;

import it.docSys.model.CreatedDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatedDocumentRepository extends JpaRepository<CreatedDocument, Long> {
}
