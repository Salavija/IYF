package it.documentManagementSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.docSys.DTO.GetDocumentDTO;
import it.docSys.DTO.PutDocumentDTO;
import it.docSys.model.Document;
import it.documentManagementSystem.DTO.UserGetDTO;
import it.documentManagementSystem.DTO.UserPutDTO;
import it.documentManagementSystem.model.User;
import it.documentManagementSystem.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServices {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private GroupRepository groupRepository;
  @Autowired
  private DocumentRepository documentRepository;

    public UserServices(UserRepository userRepository, GroupRepository groupRepository, DocumentRepository documentRepository ) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.documentRepository = documentRepository;
    }

    @Transactional(readOnly = true)
    public List<UserGetDTO> findAllUser() {
        return userRepository.findAll().stream().map((user) ->
                new UserGetDTO(
                        user.getUserId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getPassword(),
        ).collect(Collectors.toList());
    }

    @Transactional
    public UserGetDTO findByUserId(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return new UserGetDTO(user.getUserId(),
                user.getName(),
                user.getLastName(),
                user.getPassword());
        }
        return null;
    }
    

    @Transactional
    public GetDocumentDTO get(Long id) {
        Document document = documentRepository.findById(id).orElse(null);
        if (document != null) {
            return new GetDocumentDTO(document.getId(), document.getAuthor(), document.getType(),
                    document.getName(), document.getDescription(), document.getSubmissionDate(),
                    document.getApprovingDate(), document.getRejectionDate(), document.getAddressee(),
                    document.getRejectionReason(), document.getAttachments());
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
    public void updateUser(Long userId, UserPutDTO userputDTO) {
      User user = userRepository.findById(userId).orElse(null);
      if(user!= null){
          user.setName(userputDTO.getName());
          user.setLastName(userputDTO.getLastName());
          user.setPassword(userputDTO.getPassword());
      }
    }

    @Transactional
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }   
 }
    
    
       
    
