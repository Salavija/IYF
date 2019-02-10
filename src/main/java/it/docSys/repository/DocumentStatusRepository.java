//package it.docSys.repository;
//
//import it.docSys.configs.States;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDate;
//
//@Transactional
//public interface DocumentStatusRepository extends JpaRepository<States, Long> {
//
//    LocalDate getTimeStamp();
//
//    States GetStatusOfDocument(Long id);
//
//    States updateStatusOfDocument(Long id);
//
//}
