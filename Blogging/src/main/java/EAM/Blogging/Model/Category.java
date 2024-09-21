package EAM.Blogging.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @Column(name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<PostCategory> postCategories;

    public Category() {
        super();
    }

    public Category(String name, String description, List<PostCategory> postCategories) {
        this.name = name;
        this.description = description;
        this.postCategories = postCategories;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PostCategory> getPostCategories() {
        return postCategories;
    }

    public void setPostCategories(List<PostCategory> postCategories) {
        this.postCategories = postCategories;
    }
}
