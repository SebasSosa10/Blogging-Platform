package EAM.Blogging.Dto;

import EAM.Blogging.Model.Post;
import EAM.Blogging.Model.User;
import jakarta.persistence.*;

import java.util.Date;

public class DtoCommentS {
    private String content;
    private boolean approved;
    private Date publishedDate;
    private User user;   // refencia del objeto
    private Post post;   // refencia del objeto

    public DtoCommentS() {

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
