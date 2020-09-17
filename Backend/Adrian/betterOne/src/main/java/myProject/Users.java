package myProject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column String userName;

    @Column String password;

    @Column String email;


    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

  //public void setUserId(Integer userId) {
    //  this.userId = userId;
   //}

    public Integer getId() {
        return id;
    }

    //public Integer getUserId() {
   //     return userId;
   // }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
   // public void setType(String type) { this.type = type; }
}
