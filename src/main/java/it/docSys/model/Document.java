package it.docSys.model;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

    @Entity
    @Table(name = "document")
    public class Document implements Serializable {

        private Document() {}

        public Document(Long id, String author, String type, @Length
                (min = 2, message = "*Title must have at least 2 characters")
        @Length(max = 200, message = "*Title must have maximum 200 characters")
                String name, String description, LocalDate submissionDate, LocalDate approvingDate,
                        LocalDate rejectionDate, String addressee, String rejectionReason,
                        byte attachments) {
            this.id = id;
            this.author = author;
            this.type = type;
            this.name = name;
            this.description = description;
            this.submissionDate = submissionDate;
            this.approvingDate = approvingDate;
            this.rejectionDate = rejectionDate;
            this.addressee = addressee;
            this.rejectionReason = rejectionReason;
            this.attachments = attachments;
        }

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

        @Column(name = "submission_date")
        private LocalDate submissionDate;

        @Column(name = "approving_date")
        private LocalDate approvingDate;

        @Column(name = "rejection_date")
        private LocalDate rejectionDate;

        @Column(name = "addressee")
        private String addressee;

        @Column(name = "rejection_reason")
        private String rejectionReason;

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

        public LocalDate getSubmissionDate() {
            return submissionDate;
        }

        public void setSubmissionDate(LocalDate submissionDate) {
            this.submissionDate = submissionDate;
        }

        public LocalDate getApprovingDate() {
            return approvingDate;
        }

        public void setApprovingDate(LocalDate approvingDate) {
            this.approvingDate = approvingDate;
        }

        public LocalDate getRejectionDate() {
            return rejectionDate;
        }

        public void setRejectionDate(LocalDate rejectionDate) {
            this.rejectionDate = rejectionDate;
        }

        public String getAddressee() {
            return addressee;
        }

        public void setAddressee(String addressee) {
            this.addressee = addressee;
        }

        public String getRejectionReason() {
            return rejectionReason;
        }

        public void setRejectionReason(String rejectionReason) {
            this.rejectionReason = rejectionReason;
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

            Document document = (Document) o;

            return id.equals(document.id);
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

