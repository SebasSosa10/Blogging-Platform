package EAM.Blogging.Dto;

import jakarta.persistence.*;

@Entity
@Table(name = "PostCategory")
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPostCategory;

    @ManyToOne   // la llave foranea
    @JoinColumn(name = "Post_id")  // referenciar la columna de llave
    private Post post;   // refencia del objeto

    @ManyToOne   // la llave foranea
    @JoinColumn(name = "Category_id")  // referenciar la columna de llave
    private Category category;   // refencia del objeto

    public PostCategory() {
        super();
    }

    public PostCategory(int idPostCategory, Post post, Category category) {
        this.idPostCategory = idPostCategory;
        this.post = post;
        this.category = category;
    }

    public int getIdPostCategory() {
        return idPostCategory;
    }

    public void setIdPostCategory(int idPostCategory) {
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
