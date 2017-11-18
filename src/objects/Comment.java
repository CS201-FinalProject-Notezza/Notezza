package objects;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Comment implements Serializable {
    public static final long serialVersionUID = 4;
    private final User user;
    private final String content;
    private final Date dateCreated;
    private Set<User> likeUsers;
    private Set<User> dislikeUsers;
    private Note note;
    
    public Comment(User user, String content, Date date, Note note) {
        this.user = user;
        this.content = content;
        this.dateCreated = date;
        this.likeUsers = new HashSet<>();
        this.dislikeUsers = new HashSet<>();
        this.note = note;
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
    
    public Note getNote() {
    	return note;
    }
    
    public boolean hasLiked(User user) {
        return likeUsers.contains(user);
    }
    
    public boolean hasDisliked(User user) {
        return dislikeUsers.contains(user);
    }
    
    public void addLike(User user) {
    	if (!likeUsers.contains(user)) {
    		likeUsers.add(user); 
    	}
    	if (dislikeUsers.contains(user)) {
    		dislikeUsers.remove(user);
    	}
    }
    
    public void addDislike(User user) {
    	if (!dislikeUsers.contains(user)) {
    		dislikeUsers.add(user); 
    	}
    	if (likeUsers.contains(user)) {
    		likeUsers.remove(user);
    	}
    }
}
