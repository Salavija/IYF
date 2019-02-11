package it.docSys.repository;

import it.docSys.model.DocType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocTypeRepo extends JpaRepository<DocType, Long> {
    DocType findByTitle(String title);
    DocType findById(long id); //kai long is mazosios, tada leidzia ivesti, o is didziosios crasina su jau egzistuojanciu.
    void deleteByTitle(String title);

    }
