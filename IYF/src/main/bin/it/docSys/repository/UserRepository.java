package it.sventes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    void removeUser(UserGetDTO usergetDTO){
       userRepositor.deleteByUserId(usergetDTO);
}
