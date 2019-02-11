package it.docSys.repository;

import it.docSys.configs.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
public interface DocumentRepositoryCustom {

    LocalDate getTimeStamp();

    States AssignStatusOfDocument(States state);

    States updateStatusOfDocument(States state);

}
