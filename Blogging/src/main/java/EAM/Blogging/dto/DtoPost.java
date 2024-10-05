package EAM.Blogging.dto;

import EAM.Blogging.model.CommentS;
import EAM.Blogging.model.PostTag;
import EAM.Blogging.model.State;
import EAM.Blogging.model.User;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.List;

public class DtoPost {
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @NotBlank(message = "Content cannot be empty")
    private String content;
    @Min(value = 0, message = "Likes cannot be negative")
    private int likes;
    @NotNull(message = "Published date cannot be null")
    private Date publishedDate;
    private User user; // Reference to the User object
    private State state; // Reference to the State object
    private List<PostTag> postTags;
    private List<CommentS> comments;

    public DtoPost() {
        super();
    }

    public DtoPost(String title, String content, int likes, Date publishedDate, User user, State state, List<PostTag> postTags, List<CommentS> comments) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.publishedDate = publishedDate;
        this.user = user;
        this.state = state;
        this.postTags = postTags;
        this.comments = comments;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getPublisheddate() {
        return publishedDate;
    }
    public void setPublisheddate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }

    public List<CommentS> getComments() {
        return comments;
    }

    public void setComments(List<CommentS> comments) {
        this.comments = comments;
    }
}
