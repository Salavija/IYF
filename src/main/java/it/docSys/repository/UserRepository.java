package it.docSys.repository;

import it.docSys.model.DocUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DocUser, Long> {
    DocUser findByUserName(String userName);
}
