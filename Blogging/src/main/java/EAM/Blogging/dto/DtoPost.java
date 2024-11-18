package EAM.Blogging.dto;

import EAM.Blogging.model.User;
import jakarta.validation.constraints.*;

import java.util.Date;

public class DtoPost {
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @NotBlank(message = "Content cannot be empty")
    private String content;
    @Min(value = 0, message = "Likes cannot be negative")
    private int likes;
    @NotNull(message = "Published date cannot be null")
    private Date publishedDate;
    private boolean isPublished;
    private User user; // Reference to the User object

    public DtoPost() {
        super();
    }

    public DtoPost(String title, String content, int likes, User user) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.publishedDate = new Date();
        this.isPublished = false;
        this.user = user;
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

    public boolean isPublished() {
        return isPublished;
    }
    public void setPublished(boolean published) {
        isPublished = published;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
