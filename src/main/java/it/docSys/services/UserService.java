package it.docSys.services;

import it.docSys.DTO.*;
import it.docSys.entities.DocUser;
import it.docSys.entities.Document;
import it.docSys.entities.GroupEntity;
import it.docSys.repository.DocumentRepository;
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

    @Autowired
    private DocumentRepository documentRepository;

    public UserService() {
    }

    public UserService(UserRepository userRepository, GroupRepo groupRepository//, DocumentRepository documentRepository
    ) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
//        this.documentRepository = documentRepository;
    }

    @Transactional(readOnly = true)
    public List<UserGetDTO> findAllUser() {
        return userRepository.findAll().stream().map((user) ->
                new UserGetDTO(user.getDocUserId(), user.getUserName(), user.getFirstName(), user.getLastName(),
                        user.getPassword(), user.getRoles())).collect(Collectors.toList());
//        , user.getGroups(), user.getDocuments()
    }

//    @Transactional
//    public UserGetDTO findByUserId(Long userId) {
//        DocUser user = userRepository.getOne(userId);//.orElse(null);
//        if (user != null) {
//            return new UserGetDTO(user.getDocUserId(), user.getUserName(), user.getFirstName(), user.getLastName(),
//                    user.getPassword(), user.getRole()//, user.getGroups(), user.getDocuments()
//            );
//        }
//        return null;
//    }


    @Transactional
    public UserGetDTO get(Long id) {
        DocUser user = userRepository.getOne(id);//.orElse(null);
        if (user != null) {
            return new UserGetDTO(user.getDocUserId(), user.getUserName(), user.getFirstName(), user.getLastName(),
                    user.getPassword(), user.getRoles()//, user.getGroups(), user.getDocuments()
            );
        }
        return null;
    }

    @Transactional
    public void createUser(UserPutDTO userputDTO) {
        DocUser user = new DocUser();
        user.setUserName(userputDTO.getUserName());
        user.setFirstName(userputDTO.getFirstName());
        user.setLastName(userputDTO.getLastName());
        user.setPassword(userputDTO.getPassword());
        user.setRoles(userputDTO.getRoles());
//        user.setGroups(userputDTO.getGroups());
//        user.setDocuments(userputDTO.getDocuments());
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(Long userId, UserPutDTO userputDTO) {
        DocUser user = userRepository.getOne(userId);//.orElse(null);
        if (user != null) {
            user.setUserName(userputDTO.getUserName());
            user.setFirstName(userputDTO.getFirstName());
            user.setLastName(userputDTO.getLastName());
            user.setPassword(userputDTO.getPassword());
            user.setRoles(userputDTO.getRoles());
//            user.setGroups(userputDTO.getGroups());
//            user.setDocuments(userputDTO.getDocuments());
        }
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    /* Assign User to particular group */

    @Transactional
    public void assignUserToGroup(Long docUserId, Long groupId) {
        GroupEntity group = groupRepository.getOne(groupId);
        DocUser user = userRepository.getOne(docUserId);
        if (group != null) {
            group.getDocUsers().add(user);
        }
        groupRepository.save(group);
    }

    /*Gets all groups  of particular user*/

    @Transactional
    public List<GroupGetDTO> getUserGroups(String username) {
        DocUser user = userRepository.findByUserName(username);
        if (user != null) {
            return user.getGroups().stream().map(group ->
                    new GroupGetDTO(group.getId(), group.getTitle())).collect(Collectors.toList());
        }
        return null;
    }

    /* Assign Document to particular User */

    @Transactional
    public void assignDocumentToUser(Long docId, String userName) {
        DocUser user = userRepository.findByUserName(userName);
        Document document = documentRepository.getOne(docId);
        if (user != null) {
            user.getDocuments().add(document);
            userRepository.save(user);
        } else {
            throw new NullPointerException("There is no user with that name");
        }
//        userRepository.save(user);
    }

    /*Gets all documents  of particular user*/

    @Transactional
    public List<TestDocDTO> getUserDocuments(String username) {
        DocUser user = userRepository.findByUserName(username);
        if (user != null) {
            return user.getDocuments().stream().map(document ->
                    new TestDocDTO(document.getId(), document.getTitle(), document.getType(),
                            document.getAuthor())).collect(Collectors.toList());
        } else {
            throw new NullPointerException("There is no user with that name");

        }
    }
}

    // Old problematic JJ method
//    @Transactional
//    public void assignDocumentToUser(GetDocumentDTO getDocumentDTO, String userName) {
////        Document document = documentRepository.getOne(docId);
//        DocUser user = userRepository.findByUserName(userName);
//        if (user != null) {
//            List<Document> documents = documentRepository.findAll();  //findAllById(getDocumentDTO.getId());
//            for (Document document : documents) {
//                user.addDocument(document);
//
//
//            } userRepository.save(user);
//        }  else {
//            throw new NullPointerException("There is no user with that username");
//
//        }
//    }

    //TODO MY ORIGINAL

//    @Transactional
//    public void assignDocumentToUser(Long docId, Long docUserId) {
//        Document document = documentRepository.getOne(docId);
//        DocUser user = userRepository.getOne(docUserId);
//        if (user != null) {
//            user.getDocuments().add(document);
//        }
//        userRepository.save(user);
//    }

//    @Transactional
//    public void addGroupsToUser(UserAddGroupsCommand userAddGroupsCommand, String username) {
//        User user = userRepository.findByUsername(username);
//        if (user != null) {
//            List<UserGroup> userGroupList = userGroupRepository.findAllById(userAddGroupsCommand.getId());
//            for (UserGroup userGroup : userGroupList) {
//                user.addGroup(userGroup);
//            }
//            userRepository.save(user);
//        }
//    }

    /*Gets all groups  of particular user*/

    /* Experimental compiling method */

//    @Transactional
//    public List<GetDocumentDTO> getUserDocuments (String username) {
//        DocUser user = userRepository.findByUserName(username);
//        if (user != null) {
//            return user.getDocuments().stream().map(document -> {
//                GetDocumentDTO getDocumentDTO = new GetDocumentDTO();
//                BeanUtils.copyProperties(document, getDocumentDTO);
//                return getDocumentDTO;
//            }).collect(Collectors.toList());
//        }  else {
//            throw new NullPointerException("No user found");


//                    new GetDocumentDTO(document.getId(), document.getAuthor(), document.getType(),
//                    document.getTitle(), document.getDescription(), document.getSubmissionDate(),
//                    document.getApprovingDate(), document.getRejectionDate(), document.getAddressee(),
//                    document.getRejectionReason(), document.getAttachments(), document.getState())).collect(Collectors.toList());




//    @Transactional(readOnly = true)
//    public List<UserGroupGetCommand> getUsersGroups(String username) {
//        User user = userRepository.findByUsername(username);
//        if (user != null) {
//            return user.getUserGroups().stream().map(userGroup -> {
//                UserGroupGetCommand userGroupGetCommand = new UserGroupGetCommand();
//                BeanUtils.copyProperties(userGroup, userGroupGetCommand);
//                return userGroupGetCommand;
//            }).collect(Collectors.toList());
//        } else {
//            throw new NullPointerException("User does not exist");
//        }
//    }

