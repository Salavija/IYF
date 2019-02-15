package it.docSys.DTO;

public class DocTypeGetDTO {


    private String title;

    public DocTypeGetDTO(String title) {
      this.title = title;
    }

    public DocTypeGetDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
