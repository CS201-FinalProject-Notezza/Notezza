package objects;

import java.io.Serializable;

public class LoginCredential implements Serializable {
    private String password;
    private String username;

    public LoginCredential(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String toString() {
        return password + username;
    }
}
