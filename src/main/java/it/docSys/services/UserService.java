package it.docSys.services;

import it.docSys.DTO.UserGetDTO;
import it.docSys.DTO.UserPutDTO;
import it.docSys.model.User;
import it.docSys.repository.DocumentRepository;
import it.docSys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.docSys.DTO.GetDocumentDTO;
import it.docSys.model.Document;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private GroupRepo groupRepository;
    @Autowired
    private DocumentRepository documentRepository;

    public UserService() {}

    public UserService(UserRepository userRepository, DocumentRepository documentRepository ) {
        this.userRepository = userRepository;
//        this.groupRepository = groupRepository;
        this.documentRepository = documentRepository;
    }

    @Transactional(readOnly = true)
    public List<UserGetDTO> findAllUser() {
        return userRepository.findAll().stream().map((user) ->
                new UserGetDTO(
                        user.getUserId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getPassword())).collect(Collectors.toList());
    }

    @Transactional
    public UserGetDTO findByUserId(Long userId) {
        User user = userRepository.getOne(userId);//.orElse(null);
        if (user != null) {
            return new UserGetDTO(user.getUserId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPassword());
        }
        return null;
    }


    @Transactional
    public UserGetDTO get(Long id) {
        User user = userRepository.getOne(id);//.orElse(null);
        if (user != null) {
            return new UserGetDTO(user.getUserId(), user.getFirstName(), user.getLastName(),
                    user.getPassword());
        }
        return null;
    }

    @Transactional
    public void createUser(UserPutDTO userputDTO) {
        User user = new User();
        user.setUserId(userputDTO.getUserId());
        user.setFirstName(userputDTO.getFirstName());
        user.setLastName(userputDTO.getLastName());
        user.setPassword(userputDTO.getPassword());
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(Long userId, UserPutDTO userputDTO) {
        User user = userRepository.getOne(userId);//.orElse(null);
        if(user!= null){
            user.setFirstName(userputDTO.getFirstName());
            user.setLastName(userputDTO.getLastName());
            user.setPassword(userputDTO.getPassword());
        }
    }

    @Transactional
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
