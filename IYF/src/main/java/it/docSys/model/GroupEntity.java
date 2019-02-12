package it.docSys.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "groupTable")
public class GroupEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //kodel sitas, gal kad nesikartotu kitose DB?
    @Column(name = "id")
    private Long id;

    @Column(name = "title", unique = true) //ar reikia cia unique???? Pasiklaust Product Ownerio??????????????????
    private String title;

//    @Column(name = "members")
//    private String members;

//TODO Gal cia reiktu ne memberiu o Useriu objekto, kurie irgi turetu buti sukurti kaip Entity???
// Pvz padaryt linka User user virsuje. Kaip pasiulymo (ne kritikos) pvz:


//    @Column(name = "users")
//    private User user;

////    @ManyToMany su grupe, vienas doko tipas su daug grupiu ir atvirksciai.
//    @ManyToMany
////    @JoinTable(table = @Table(name= "G_D"), //RAUDONUOJA table
//    @JoinTable(name= "G_D",
//            joinColumns = @JoinColumn (name="G_ID"), //nurodo esamos lenteles eilute
//            inverseJoinColumns = @JoinColumn (name= "D_ID")) //nurodo susietos lenteles (DocType) eilute
//    private List<DocType> docTypes; //gal set geriau naudoti ir hashset?? Kaip pas Juliu.


    public GroupEntity(String title) {
        this.title = title;
//        this.members = members;
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

//    public String getMembers() {
//        return members;
//    }
//
//    public void setMembers(String members) {
//        this.members = members;
//    }

//    @Override String toString() { //KAM REIKALINGAS SITAS OVERRIDINIMAS???????????? PAS JULIU YRA.
//
//    }

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


