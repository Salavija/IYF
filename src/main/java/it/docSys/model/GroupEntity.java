package it.docSys.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groupTable")
public class GroupEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", unique = true)
    private String title;



    /*@ManyToMany su doko tipu, viena grupe gali tureti daug doku tipu ir atvirksciai.*/
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name= "G_Dt",
            joinColumns = @JoinColumn (name="G_ID"), //nurodo esamos lenteles eilute
            inverseJoinColumns = @JoinColumn (name= "Dt_ID")) //nurodo susietos lenteles (DocType) eilute
    private Set<DocType> docTypes = new HashSet<>();

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name= "G_Us",
            joinColumns = @JoinColumn (name="G_ID"), //nurodo esamos lenteles eilute
            inverseJoinColumns = @JoinColumn (name= "Us_ID")) //nurodo susietos lenteles (User) eilute
    private Set<User> users = new HashSet<>();


    public GroupEntity(String title, Set<DocType> docTypes) {
        this.title = title;
        this.docTypes = docTypes;
    }

    public GroupEntity() {
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<DocType> getDocTypes() {
        return docTypes;
    }

    public void setDocTypes(Set<DocType> docTypes) {
        this.docTypes = docTypes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupEntity groupEntity = (GroupEntity) o;

        return id.equals(groupEntity.id);
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }
}


