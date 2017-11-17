package objects;

public class UserCredential {
    private final String fname;
    private final String lname;
    private final String username;
    private final String email;
    private String password;
    private final boolean isInstructor;
    private boolean isVisible;

    public UserCredential(String fname, String lname, String username, String email, String password, boolean isInstructor, boolean isVisible) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isInstructor = isInstructor;
        this.isVisible = isVisible;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isInstructor() {
        return isInstructor;
    }

    public boolean isVisible() {
        return isVisible;
    }
}
