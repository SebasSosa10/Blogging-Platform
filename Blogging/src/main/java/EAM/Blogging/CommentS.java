package EAM.Blogging;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comment")
public class CommentS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComments;

    @Column (name = "content")
    private String content;

    @Column(name = "approved")
    private boolean approved;

    @Column (name = "published_date")
    private Date publisheddate;

    @ManyToOne   // la llave foranea
    @JoinColumn(name = "User_id")  // referenciar la columna de llave
    private User user;   // refencia del objeto

    @ManyToOne   // la llave foranea
    @JoinColumn(name = "Post_id")  // referenciar la columna de llave
    private Post post;   // refencia del objeto

    public CommentS() {
        super();
    }

    public CommentS(int idComments, String content, boolean approved, Date publisheddate, User user, Post post) {
        this.idComments = idComments;
        this.content = content;
        this.approved = approved;
        this.publisheddate = publisheddate;
        this.user = user;
        this.post = post;
    }

    public int getIdComments() {
        return idComments;
    }

    public void setIdComments(int idComments) {
        this.idComments = idComments;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
