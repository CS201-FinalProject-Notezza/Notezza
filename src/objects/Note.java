package objects;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Note {
    // Need discuss on setting finals
    private final User user;
    private final String title;
    private final String textContent;
    private Vector<String> links;
    private Vector<String> tags;
    private final String dateCreated;
    private Vector<Comment> comments;
    private Set<User> likeUsers;
    private Set<User> dislikeUsers;

    public Note(User user, String title, Vector<String> links, Vector<String> tags, String date, String textContent) {
        this.user = user;
        this.title = title;
        this.links = links;
        this.tags = tags;
        // if we are not allow to change anything after uploading
        this.dateCreated = date;
        this.textContent = textContent;
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

    public String getDateCreated() {
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

    public int getRating() {
        return likeUsers.size() - dislikeUsers.size();
    }

    public boolean hasLiked(User user) {
        return likeUsers.contains(user);
    }

    public boolean hasDisliked(User user) {
        return dislikeUsers.contains(user);
    }

    public void addComment(Comment comment) {
        if (comments != null) {
            comments.add(comment);
        } else {
            comments = new Vector<>();
            comments.add(comment);
        }
    }

    public void addLike(User user) {
        if (likeUsers != null) {
            likeUsers.add(user);
        } else {
            likeUsers = new HashSet<>();
            likeUsers.add(user);
        }
    }

    public void addDislike(User user) {
        if (dislikeUsers != null) {
            dislikeUsers.add(user);
        } else {
            dislikeUsers = new HashSet<>();
            dislikeUsers.add(user);
        }
    }

    @Override
    // I actually don't know what this does.
    // Someone implement this.
    public String toString() {
        return "";
    }
}
