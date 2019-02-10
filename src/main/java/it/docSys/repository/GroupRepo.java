package it.docSys.repository;

import it.docSys.model.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<GroupEntity, Long> {
    GroupEntity findByTitle(String title);
    void deleteByTitle(String title);
}
