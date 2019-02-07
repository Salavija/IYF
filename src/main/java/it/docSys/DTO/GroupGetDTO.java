package it.docSys.DTO;

public class GroupGetDTO {

//    private Long id; //ID tik DB sukuriamas, tai yra vidinis parametras.
    private String title;
//    private String members;


    public GroupGetDTO(String title) {
        this.title = title;
//        this.members = members;//Kai sitam konstruktoriui buvo daugiau dalyku, tai servoisas getAllGroups negalejo jo resolvint
        //matyt del to, kad konstruktorius reikalavo atiduoti daugiau lauku, nei metodas galejo paimt? I tarpa galima gal deti atskira klase
        //kuri butu dto objektas, kuris paimtu tik tuos laukus, kuriu reikia.
    }

    public GroupGetDTO() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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
