package it.docSys.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity  //serializable: 24 psl Java Persistance 11 paskaitos medziaga papildoma.
@Table (name = "doc_type")
public class DocType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "documentType_id")
    private Long id;

    @Column(name = "doc_type", unique = true, nullable = false)//TODO nutarek, kad ilgis turi buti max 200 simboliu.
    //TODO Length (min = 3, message = "Document type must have at least 5 characters") Padaryti validacija,s kaip pas d4stytoja. Cia is AUros shopo pvz.
    private String title;


    /*Sarysis  one to many su sukurtais dokais - 1 doko tipas gali tureti daug doku*/ //TODO PUT paraysti, kad pridetu.
    @OneToMany (mappedBy = "docType")
    private List<Document> documents = new ArrayList<>();

    public void addDocument (Document document) { //TODO sitas metodas niekur nepanaudotas, nors galetu buti skiriant dokams tipus.
        this.documents.add(document);
        document.setType(this.title);
    } //TODO ar tikrai paeis taip, kad cia tik title paduodamas, o ne visas DocTipas. Turetu paeiti, nes Document entityj'e tipas yra String'as (setType priima stringa).


    /*Many to many sarysis su grupemis (1 doko tipas daug grupiu ir atvirksciai)*/
    @ManyToMany(mappedBy = "docTypes")
    private Set<GroupEntity> groups = new HashSet<>();


    public DocType() {
    }

    public DocType(String title, List<Document> documents, Set<GroupEntity> groups) {
        this.title = title;
        this.documents = documents;
        this.groups = groups;
    }

    /*geteriai ir seteriai*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String docType) {

        this.title = docType;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Set<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
    }

    //TODO Apie primary key pasiksiatyti destytojo kur jis yra daves papildoma medziaga.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocType docType = (DocType) o;

        return id.equals(docType.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }



}
