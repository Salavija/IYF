package it.docSys.DTO;

public class UserPutDTO {

    //private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String role;


    public UserPutDTO(String userName, String firstName, String lastName, String password, String role) {
     //   this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }


//    public Long getUserId() {
//        return userId;
//    }


//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String name) {
        this.firstName = name;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

}