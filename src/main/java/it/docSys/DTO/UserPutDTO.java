package it.docSys.DTO;


import it.docSys.configs.Roles;
import it.docSys.entities.Role;

import java.util.Set;

public class UserPutDTO {

    private String userName;
//    private Long userId;
    private String firstName;
    private String lastName;
    private String password;
    private Set<Role> roles;
//    private Set<GroupEntity> groups;
//    private Set<Document> documents;


    public UserPutDTO(String userName, String firstName, String lastName, String password,
                      Set<Role> roles//, Set<GroupEntity> groups//, Set<Document> documents
    ) {
//        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.roles = roles;
//        this.groups = groups;
//        this.documents = documents;
    }

//    public Set<Document> getDocuments() {
//        return documents;
//    }
//
//    public void setDocuments(Set<Document> documents) {
//        this.documents = documents;
//    }

    public UserPutDTO() {}

//    public Set<GroupEntity> getGroups() {
//        return groups;
//    }
//
//    public void setGroups(Set<GroupEntity> groups) {
//        this.groups = groups;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRole(Set<Role> roles) {
        this.roles = roles;
    }

//    public Long getUserId() {
//        return userId;
//    }
//
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}

