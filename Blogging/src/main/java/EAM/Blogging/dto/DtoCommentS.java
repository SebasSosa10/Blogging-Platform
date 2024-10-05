package EAM.Blogging.dto;

import EAM.Blogging.model.Post;
import EAM.Blogging.model.User;
import jakarta.validation.constraints.*;

import java.util.Date;

public class DtoCommentS {

    @NotBlank(message = "Content cannot be empty")
    @Size(max = 2000, message = "Content cannot exceed 2000 characters")
    private String content;
    private boolean approved;
    @NotNull(message = "Published date cannot be null")
    private Date publishedDate;
    @NotNull(message = "User cannot be null")
    private User user; // Reference to the User object
    @NotNull(message = "Post cannot be null")
    private Post post; // Reference to the Post object

    public DtoCommentS() {
        super();
    }

    public DtoCommentS(String content, boolean approved, Date publishedDate, User user, Post post) {
        this.content = content;
        this.approved = approved;
        this.publishedDate = publishedDate;
        this.user = user;
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
