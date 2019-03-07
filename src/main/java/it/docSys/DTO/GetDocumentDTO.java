package it.docSys.DTO;

import it.docSys.enums.States;

import java.time.LocalDate;

//TODO Team Example ID's ALL Strings (2 nd Edition fixed to be List<Long>), My version was Long; Trying to get them Strings;

public class GetDocumentDTO {

    private Long id;
    private String author;
    private String type;
    private String title;
    private String description;
    private LocalDate submissionDate;
    private LocalDate approvingDate;
    private LocalDate rejectionDate;
    private String addressee;
    private String rejectionReason;
    private byte attachments;
    private States state;



    public GetDocumentDTO(Long id, String author, String type, String title, String description,
                          LocalDate submissionDate, LocalDate approvingDate, LocalDate rejectionDate,
                          String addressee, String rejectionReason, byte attachments, States state) {
        this.id = id;
        this.author = author;
        this.type = type;
        this.title = title;
        this.description = description;
        this.submissionDate = submissionDate;
        this.approvingDate = approvingDate;
        this.rejectionDate = rejectionDate;
        this.addressee = addressee;
        this.rejectionReason = rejectionReason;
        this.attachments = attachments;
        this.state = state;
    }

    public GetDocumentDTO() {}

//    public Long getId() {
//        return id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }
}