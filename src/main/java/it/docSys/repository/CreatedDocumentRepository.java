package it.docSys.repository;

import it.docSys.model.CreatedDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatedDocumentRepository extends JpaRepository<CreatedDocument, Long> {
//
//    long create(CreatedDocument createdDocument);
//    void update(long id, CreatedDocument createdDocument);
//    void delete(long id);
}
