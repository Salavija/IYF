package it.sventes.model.document;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class CreatedDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_id")
    private Long id;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name ="type", nullable = false)
    private String type; // Or some other type of data???

    @Column(name = "title", nullable = false, unique = true)
    @Length(min = 2, message = "*Title must have at least 2 characters")
    @Length(max = 200, message = "*Title must have maximum 200 characters")
    private String name;

    @Column(name = "description")
    private String description;

//    @Column(name = "submission_date")     NOT SUBMITTED ONLY CREATED
//    private LocalDate submissionDate;

//    @Column(name = "approving_date")      NOT APPROVED ONLY CREATED
//    private LocalDate approvingDate;

//    @Column(name = "rejection_date")      NOT REJECTED ONLY CREATED
//    private LocalDate rejectionDate;

    @Column(name = "addressee")
    private String addressee;

//    @Column(name = "rejection_reason")    NOT REJECTED ONLY CREATED
//    private String rejectionReason;

    @Column(name = "attachments")
    private byte attachments;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public byte getAttachments() {
        return attachments;
    }

    public void setAttachments(byte attachments) {
        this.attachments = attachments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreatedDocument createdDocument = (CreatedDocument) o;

        return id.equals(createdDocument.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}


