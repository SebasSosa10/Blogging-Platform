package EAM.Blogging.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "likes")
    private int likes;

    @Column (name = "published_date")
    private Date publisheddate;

    @Column (name = "is_Published")
    private boolean isPublished;

    @ManyToOne   // la llave foranea
    @JoinColumn(name = "user_id")  // referenciar la columna de llave
    private User user;   // refencia del objeto

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostTag> postTags;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<CommentS> comments;

    public Post() {
        super();
    }

    public Post(String title, String content, int likes, Date publisheddate, User user, boolean isPublished, List<PostTag> postTags, List<CommentS> comments) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.publisheddate = publisheddate;
        this.user = user;
        this.isPublished = isPublished;
        this.postTags = postTags;
        this.comments = comments;
    }

    public void addLike(){
        this.likes++;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
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
        return publisheddate;
    }

    public void setPublisheddate(Date publisheddate) {
        this.publisheddate = publisheddate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
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
