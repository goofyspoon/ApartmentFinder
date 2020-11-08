package myProject;

import javax.persistence.*;

@Entity
class Users{

    //need preferences (budget, location(east,south,west,north,on campus), bedroom number)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;

    @Column String userName;

    @Column String password;

    @Column String email;

    @Column boolean isAdmin;

    public Users() {
        userId = null;
        userName = null;
        password = null;
        email = null;
        isAdmin = false;
    }

    public Users(int UserId, String UserName, String Password, String Email) {
        userId = UserId;
        userName = UserName;
        password = Password;
        email = Email;
    }


    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {this.email = email; }

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

    public boolean getAdmin() {
        return isAdmin;
    }

    // public void setType(String type) { this.type = type; }
}
