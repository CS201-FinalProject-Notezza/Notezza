package objects;

import java.util.Date;
import java.util.Set;

public class Comment {

    private User user;
    private String content;
    private Date dateCreated;
    private Set<User> likeUsers;
    private Set<User> dislikeUsers;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<User> getLikeUsers() {
        return likeUsers;
    }

    public void setLikeUsers(Set<User> likeUsers) {
        this.likeUsers = likeUsers;
    }

    public Set<User> getDislikeUsers() {
        return dislikeUsers;
    }

    public void setDislikeUsers(Set<User> dislikeUsers) {
        this.dislikeUsers = dislikeUsers;
    }
}
