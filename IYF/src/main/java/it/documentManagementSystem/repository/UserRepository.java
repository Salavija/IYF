package it.documentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import it.docSys.model.DocType;
import it.documentManagementSystem.DTO.UserGetDTO;
import it.documentManagementSystem.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
     default User findByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

     default void deleteUser(long id) {
		// TODO Auto-generated method stub
	}
}


