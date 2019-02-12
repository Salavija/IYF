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
    @GeneratedValue(strategy = GenerationType.AUTO) //kodel sitas, gal kad nesikartotu kitose DB? Ar tikrai AUTO geriausias?
    @Column(name = "id")
    private Long id;

    @Column(name = "title", unique = true)
    private String title;


//TODO Gal cia reiktu ne memberiu o Useriu objekto, kurie irgi turetu buti sukurti kaip Entity???
    //TODO aha, reiketu, tik tikriauisiai per sarysi susieto "many to many" ir panaudoto konstruktoriuje.
// Pvz padaryt linka User user virsuje. Kaip pasiulymo (ne kritikos) pvz:
//    @Column(name = "users")
//    private User user;


    /*@ManyToMany su doko tipu, viena grupe gali tureti daug doku tipu ir atvirksciai.*/
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name= "G_Dt",
            joinColumns = @JoinColumn (name="G_ID"), //nurodo esamos lenteles eilute
            inverseJoinColumns = @JoinColumn (name= "Dt_ID")) //nurodo susietos lenteles (DocType) eilute
    private Set<DocType> docTypes = new HashSet<>();


    public GroupEntity(String title, Set<DocType> docTypes) {
        this.title = title;
        this.docTypes = docTypes;
    }

    public GroupEntity() {
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

  //TODO ??Override String toString??

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupEntity groupEntity = (GroupEntity) o;

        return id.equals(groupEntity.id);
    }

    //TODO nezinau ar id ar title det geriau

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}


