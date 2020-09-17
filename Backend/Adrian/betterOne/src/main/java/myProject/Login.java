package myProject;

public class Login {

    String username;
    String password;
    int idNum;
    String email;

    public Login(String userName, String password, int idNum, String email){
        this.username = userName;
        this. password = password;
        this.idNum = idNum;
        this. email = email;
    }

    public Login(){}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getIdNum() {
        return idNum;
    }

    public String getUsername() {
        return username;
    }
}
