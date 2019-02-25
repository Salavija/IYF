package it.docSys.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import it.docSys.model.Document;

@Entity
public class DocUser {

    public DocUser() {}

    public DocUser(Long docUserId, String userName, String firstName, String lastName,
                   String password, String role, Set<GroupEntity> groups, Set<Document> documents
    ) {
        this.docUserId = docUserId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.groups = groups;                           //Maybe it should be deleted?
        this.documents = documents;
        this.role = role;                             //Admin or User

      //TODO Should be min 2 Roles; 1. Admin 2. Employee; Just to redirect after login;
      //TODO It will be just a field;
      //TODO depending on Group it is Assigned (exact String to be checked as a Variant) privileges (Might be Other Entity) are assigned;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long docUserId;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "name")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @ManyToMany(mappedBy = "docUsers")
    private Set<GroupEntity> groups = new HashSet<>();

    /*Sarysis su dokumentu one to many - daug doku vienas autorius*/

//    @OneToMany (mappedBy = "docUser")
//    private Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private Set<Document> documents;

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(name = "user_of_group",
//            joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
//    private Set<GroupEntity> groups = new HashSet<>();

//    @Column(name = "user_groups")
//    @ElementCollection(targetClass = GroupEntity.class)
//    private Set<GroupEntity> groups = new HashSet<>();
//
//    @Column(name = "user_documents")
//    @ElementCollection(targetClass = Document.class)
//    private Set<Document> documents = new HashSet<>();


    public Set<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(name = "user_document",
//            joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "document_id"))
//    private Set<Document> documents = new HashSet<>();

    public void addGroup(GroupEntity groupEntity){
        this.groups.add(groupEntity);
        groupEntity.addUser(this);
    }

//    public void addDocument(Document document){
//        this.documents.add(document);
//        document.addUser(this);
//    }

    public void addDocument(Document document) {
        documents.add(document);
        document.setAuthor(this);
    }

    public void removeDocument(Document document) {
        documents.remove(document);
        document.setAuthor(null);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getDocUserId() {
        return docUserId;
    }

    public void setDocUserId(Long docUserId) {
        this.docUserId = docUserId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public Set<GroupEntity> getGroups() {
//        return groups;
//    }
//
//    public void setGroups(Set<GroupEntity> groups) {
//        this.groups = groups;
//    }
//
//    public Set<Document> getDocuments() {
//        return documents;
//    }
//
//    public void setDocuments(Set<Document> documents) {
//        this.documents = documents;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocUser user = (DocUser) o;

        return docUserId.equals(user.docUserId);
    }

    @Override
    public int hashCode() {
        return docUserId.hashCode();
    }
}

