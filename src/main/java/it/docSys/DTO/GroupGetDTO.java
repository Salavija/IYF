package it.docSys.DTO;

public class GroupGetDTO {

    private Long id;
    private String title;
//    private String members;


    public GroupGetDTO(Long id, String title) {
        this.id = id;
        this.title = title;

    }

    public GroupGetDTO() {
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
}