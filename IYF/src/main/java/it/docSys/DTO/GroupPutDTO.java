package it.docSys.DTO;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class GroupPutDTO {

    @NotNull
    @Length(min = 1, max = 200)
    private String title;
//    private String members; //vardai/pavardes/pareigos??? listas?

    public GroupPutDTO(@NotNull @Length(min = 1, max = 200) String title) {
        this.title = title;
//        this.members = members;
    }

    public GroupPutDTO() {
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
