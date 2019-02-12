package it.docSys.repository;

import it.docSys.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User findByUserId(Long userId);

//    default void deleteUser(long id) {
//        // TODO Auto-generated method stub
//    }
}
