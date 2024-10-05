package EAM.Blogging.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PostCategory")
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostCategory;

    @ManyToOne   // la llave foranea
    @JoinColumn(name = "Post_id")  // referenciar la columna de llave
    private Post post;   // refencia del objeto

    @ManyToOne   // la llave foranea
    @JoinColumn(name = "Category_id")  // referenciar la columna de llave
    private Category category;   // refencia del objeto

    public PostCategory() {
        super();
    }

    public PostCategory(Post post, Category category) {
        this.post = post;
        this.category = category;
    }

    public Long getIdPostCategory() {
        return idPostCategory;
    }

    public void setIdPostCategory(Long idPostCategory) {
        this.idPostCategory = idPostCategory;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
