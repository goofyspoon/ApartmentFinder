package myProject;

import javax.persistence.*;

@Entity
class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;

    @Colunm
    String userName;

    @Colunm
    String password;

    @Colunm
    String email;

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    public void setType(String type) {
        this.type = type;
    }
}
