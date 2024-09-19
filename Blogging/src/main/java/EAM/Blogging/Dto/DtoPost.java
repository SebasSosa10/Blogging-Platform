package EAM.Blogging.Dto;

import EAM.Blogging.Model.CommentS;
import EAM.Blogging.Model.PostTag;
import EAM.Blogging.Model.State;
import EAM.Blogging.Model.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class DtoPost {
    private String title;
    private String content;
    private int likes;
    private Date publishedDate;
    private User user;   // refencia del objeto
    private State state;
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
