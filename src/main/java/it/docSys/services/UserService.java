package it.docSys.services;

import it.docSys.DTO.UserGetDTO;
import it.docSys.DTO.UserPutDTO;
import it.docSys.model.GroupEntity;
import it.docSys.model.User;
import it.docSys.repository.GroupRepo;
import it.docSys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepo groupRepository;
//    @Autowired
//    private DocumentRepository documentRepository;

    public UserService() {}

    public UserService(UserRepository userRepository//, DocumentRepository documentRepository
    ) {
        this.userRepository = userRepository;
//        this.groupRepository = groupRepository;
//        this.documentRepository = documentRepository;
    }

    @Transactional(readOnly = true)
    public List<UserGetDTO> findAllUser() {
        return userRepository.findAll().stream().map((user) ->
                new UserGetDTO(user.getUserId(), user.getUserName(), user.getFirstName(),
                        user.getLastName(), user.getRole(), user.getPassword())).collect(Collectors.toList());
    }

    @Transactional
    public UserGetDTO findByUserId(Long userId) {
        User user = userRepository.getOne(userId);//.orElse(null);
        if (user != null) {
            return new UserGetDTO(user.getUserId(), user.getUserName(), user.getFirstName(), user.getLastName(),
                    user.getPassword(), user.getRole());
        }
        return null;
    }


    @Transactional
    public UserGetDTO get(Long id) {
        User user = userRepository.getOne(id);//.orElse(null);
        if (user != null) {
            return new UserGetDTO(user.getUserId(), user.getUserName(), user.getFirstName(), user.getLastName(),
                    user.getPassword(), user.getRole());
        }
        return null;
    }

    @Transactional
    public void createUser(UserPutDTO userputDTO) {
        User user = new User();
        user.setUserName(userputDTO.getUserName());
        user.setFirstName(userputDTO.getFirstName());
        user.setLastName(userputDTO.getLastName());
        user.setPassword(userputDTO.getPassword());
        user.setRole(userputDTO.getRole());
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(Long userId, UserPutDTO userputDTO) {
        User user = userRepository.getOne(userId);//.orElse(null);
        if(user!= null){
            user.setUserName(userputDTO.getUserName());
            user.setFirstName(userputDTO.getFirstName());
            user.setLastName(userputDTO.getLastName());
            user.setPassword(userputDTO.getPassword());
            user.setRole(userputDTO.getRole());
        }
    }

    @Transactional
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    @Transactional
    public void assignUserToGroup (Long userId, Long groupId) {
        GroupEntity group = groupRepository.getOne(groupId);
        User user = userRepository.getOne(userId);
        if (group != null) {
            group.getUsers().add(user);
        }
    }
}
