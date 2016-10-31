package model;

/**
 * Created by tmoiseev on 10/31/2016.
 */
public class LoginModel {

    private String email;
    private String password;

    public LoginModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPassword() {

        return password;
    }

    public  String getEmail() {
        return  email;
    }

    public LoginModel setEmail(String email) {
        this.email = email;
        return this;
    }

}
