package it.docSys.DTO;


import it.docSys.model.Document;
import it.docSys.model.GroupEntity;

import java.util.Set;

public class UserGetDTO {

    private String userName;
    private Long userId;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
    private Set<GroupEntity> groups;
    private Set<Document> documents;


    public UserGetDTO(Long userId, String userName, String firstName, String lastName, String password,
                      String role, Set<GroupEntity> groups, Set<Document> documents) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.groups = groups;
        this.documents = documents;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public UserGetDTO(String title) {}

    public Set<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }


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

