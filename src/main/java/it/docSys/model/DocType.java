package it.docSys.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity  //serializable: 24 psl Java Persistance 11 paskaitos medziaga papildoma.
@Table (name = "doc_type")
public class DocType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "documentType_id")
    private Long id;

    @Column(name = "doc_type", unique = true, nullable = false)//ilgis turi buti max 200 simboliu.
    //Length (min = 3, message = "Document type must have at least 5 characters") Padaryti validacija,s kaip pas d4stytoja. Cia is AUros shopo pvz.
    private String title;

//    //Many to many sarysis su grupemis (1 dokas daug gruoiu ir atvirksciai)
//    @ManyToMany(mappedBy = "docTypes")
//    private List<GroupEntity> groups;


    public DocType() { //ar pas mane buvo konstruktorius su dalykais ir be ju?????
    }

    public DocType(String docType) {
        this.title = docType;
    }

    //geteriai ir seteriai
    public Long getId() { //ir ar pa s mane buvo ID seteriai ir geteriai?????????????????????????????????????????????????
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


    //Apie primary key pasiksiatyti destytojo kur jis yra daves papildoma medziaga. Ir sergejui pasiulyti.
    //cia one to many buvo ideta ir cascade is Auros pvz. Kaip pas Jona? Buvo ir pas ji tik uzkomentuota.

    //yra pas AUra shopo pavyzdyje kur perraso Overrides Object ir hashcode. Ar to reikia, pasidom4ti daugiau.



}
