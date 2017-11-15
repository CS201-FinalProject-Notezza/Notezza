package objects;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;


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
    private SortType sortType;
    
    
    public Note(User user, String title, Vector<String> links, Vector<String> tags, Date date, String textContent) {
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
        this.sortType = SortType.DATE;
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

    public int getNumComments(){ return comments.size(); }

    public int getNumLikes(){ return likeUsers.size(); }

    public int getRating() { return likeUsers.size() - dislikeUsers.size(); }

    public boolean hasLiked(User user) {
        return likeUsers.contains(user);
    }

    public boolean hasDisliked(User user) {
        return dislikeUsers.contains(user);
    }

    public void addComment(Comment comment) { comments.add(comment); }

    public void addLike(User user) { likeUsers.add(user);}

    public void addDislike(User user) { dislikeUsers.add(user);}

    public void setSortBy(SortType SortType){ this.sortType = SortType; }
    
    @Override
    public int compareTo(Note o) {
        switch (sortType) {
                // Sort by number of comments
            case NUMBER_OF_COMMENTS:
                return Integer.compare(this.getNumComments(), o.getNumComments());
                // Sort by number of likes
            case NUMBER_OF_LIKES:
                return Integer.compare(this.getNumLikes(), o.getNumLikes());
                // Sort by rating
            case RATING:
                return Integer.compare(this.getRating(), o.getRating());
                // Sort by date
            case DATE:
            default:
                return this.dateCreated.compareTo(o.getDateCreated());
        }
    }

    @Override
    // This toString method is used for the convenience of Substring Search
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Get rid of all non alpha numerical values of everything
        String title = this.title.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String textContext = this.textContent.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        sb.append(title);
        sb.append(textContext);
        for (String tag : tags) {
            tag = tag.replaceAll("[^A-Za-z0-9]", "");
            sb.append(tag);
        }
        return sb.toString();
    }

    public boolean search(String[] keywords) {
        for (String keyword : keywords) {
            String noteContent = this.toString();
            if (noteContent.contains(keyword.replaceAll("[^A-Za-z0-9]", "").toLowerCase())) {
                return true;
            }
        }
        return false;
    }


}
