package objects;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.Date;

public class Note implements Comparable<Note> {

    private final User user;
    private final String title;
    private final String textContent;
    private Vector<String> links;
    private Vector<String> tags;
    private final Date dateCreated;
    private Vector<Comment> comments;
    private Set<User> likeUsers;
    private Set<User> dislikeUsers;
    private int numComments;
    private int numLikes;
    private int numDislikes;
    private int sortBy;
    
    
    public Note(User user, String title, Vector<String> links, Vector<String> tags, String date, String textContent) {
        this.user = user;
        this.title = title;
        this.links = links;
        this.tags = tags;
        // if we are not allow to change anything after uploading
        this.dateCreated = date;
        this.textContent = textContent;
        this.comments = new Vector<>();
        this.likeUsers = new HashSet<>();
        this.dislikeUsers = new HashSet<>();
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getTextContent() {
        return textContent;
    }

    public Vector<String> getLinks() {
        return links;
    }

    public Vector<String> getTags() {
        return tags;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Vector<Comment> getComments() {
        return comments;
    }

    public Set<User> getLikeUsers() {
        return likeUsers;
    }

    public Set<User> getDislikeUsers() {
        return dislikeUsers;
    }

    public void setLinks(Vector<String> links) {
        this.links = links;
    }

    public void setTags(Vector<String> tags) {
        this.tags = tags;
    }

    public void setComments(Vector<Comment> comments) {
        this.comments = comments;
    }

    public int getNumComments(){
        return numComments;
    }
    
    public int getNumLikes(){
        return numLikes;
    }
    
    public int getRating() {
        return numLikes - numDislikes;
    }

    public boolean hasLiked(User user) {
        return likeUsers.contains(user);
    }

    public boolean hasDisliked(User user) {
        return dislikeUsers.contains(user);
    }

    public void addComment(Comment comment) { comments.add(comment); }

    public void addLike(User user) { likeUsers.add(user); numLikes++;}

    public void addDislike(User user) { dislikeUsers.add(user); numDislikes++;}

    public void setSortBy(int sortBy){
        this.sortBy = sortBy;
    }
    
    @Override
    public int compareTo(Note o) {
        switch (sortBy) {
                
                // Sort by number of comments
            case 1:
                if(this.numComments > o.getNumComments()){
                    return 1;
                } else if ( this.numComments == o.getNumComments() ){
                    return 0;
                } else {
                    return -1;
                }
                // Sort by number of likes
            case 2:
                if(this.numLikes > o.getNumLikes()){
                    return 1;
                } else if ( this.numLikes == o.getNumLikes()){
                    return 0;
                } else {
                    return -1;
                }
                // Sort by rating
            case 3:
                if(this.getRating() > o.getRating()){
                    return 1;
                } else if ( this.getRating() == o.getRating()){
                    return 0;
                } else {
                    return -1;
                }
                // Sort by date
            case 0:
            default:
                return this.dateCreated.compareTo(o.getDateCreated());
        }
    }
    @Override
    // I actually don't know what this does.
    // Someone implement this.
    public String toString() {
        return "";
    }
}
