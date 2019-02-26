package it.docSys.repository;

import it.docSys.entities.DocType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocTypeRepo extends JpaRepository<DocType, Long> {
    DocType getByTitle(String title);
//    DocType findById(long id); //kai long is mazosios, tada leidzia ivesti, o is didziosios crasina su jau egzistuojanciu.
    boolean existsByTitle(String title);
    void deleteByTitle(String title);

    }
