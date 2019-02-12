package it.sventes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepositor;
  @Autowired
  private GroupRepository groupRepository;
  @Autowired
  private DocumentRepository documentRepository;

    public UserService(UserRepository userRepository, GroupRepository groupRepository, DocumentRepository documentRepository ) {
        this.recordStudioRepo = userRepository;
        this.groupRepository = groupRepository;
        this.documentRepository = documentRepository;
    }

    @Transactional(readOnly = true)
    public List<UsergetDTO> findAllUser() {
        return userRepository.findAll().stream().map((user) ->
                new UserGetDTO(
                        user.getUserId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getPassword(),
        ).collect(Collectors.toList());
    }

    @Transactional
    public PerformerGetDTO findByUserId(String userId) {
        User user = UserRepository.findByUserId(userId);
        if (user != null) {
            return new UserGetDTO(user.getUserId(),
                user.getUserId(),
                user.getName(),
                user.getLastName(),
                user.getPassword());
        }
        return null;
    }

    @Transactional
    public void createUser(UserPutDTO userputDTO) {
        User user = new User();
        user.setUserId(userputDTO.getUserId());
        user.setName(userputDTO.getName());
        user.setLastName(userputDTO.getLastName());
        user.setPassword(userputDTO.getPassword());
    }

    @Transactional
    public void updateUser(String userId, UserPutDTO userputDTO) {
      User user = User.findByUserId();
      if(user!= null){
          user.setFirstName(putDTO.getFirstName());
          user.setLastName(putDTO.getLastName());
          user.setPassword(putDTO.getPassword());
      }
    }

    @Transactional
    public void removeUser(UserGetDTO usergetDTO){
        userRepositor.deleteByUserId(usergetDTO);
    }
}
