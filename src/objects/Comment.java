package objects;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Comment implements Serializable{
    public static final long serialVersionUID = 4;
    private final User user;
    private final String content;
    private final Date dateCreated;
    private Set<User> likeUsers;
    private Set<User> dislikeUsers;
    
    public Comment(User user, String content, Date date) {
        this.user = user;
        this.content = content;
        this.dateCreated = date;
        this.likeUsers = new HashSet<>();
        this.dislikeUsers = new HashSet<>();
    }
    
    public User getUser() {
        return user;
    }
    
    public String getContent() {
        return content;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }
    
    public Set<User> getLikeUsers() {
        return likeUsers;
    }
    
    public Set<User> getDislikeUsers() {
        return dislikeUsers;
    }
    
    public int getScore() {
        return likeUsers.size() - dislikeUsers.size();
    }
    
    public boolean hasLiked(User user) {
        return likeUsers.contains(user);
    }
    
    public boolean hasDisliked(User user) {
        return dislikeUsers.contains(user);
    }
    
    public void addLike(User user) { likeUsers.add(user); }
    
    public void addDislike(User user) { dislikeUsers.add(user); }
}
