package EAM.Blogging;

import jakarta.persistence.*;

@Entity
@Table(name = "PostTag")
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPostTag;

    @ManyToOne   // La llave foránea
    @JoinColumn(name = "Post_id")  // Referencia a la columna de llave
    private Post post;   // Referencia al objeto

    @ManyToOne   // La llave foránea
    @JoinColumn(name = "Tag_id")  // Referencia a la columna de llave
    private Tag tag;   // Referencia al objeto

    public PostTag() {
        super();
    }

    public PostTag(int idPostTag, Post post, Tag tag) {
        this.idPostTag = idPostTag;
        this.post = post;
        this.tag = tag;
    }

    public int getIdPostTag() {
        return idPostTag;
    }

    public void setIdPostTag(int idPostTag) {
        this.idPostTag = idPostTag;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
