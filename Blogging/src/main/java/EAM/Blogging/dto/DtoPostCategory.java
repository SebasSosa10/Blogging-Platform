package EAM.Blogging.dto;

import EAM.Blogging.model.Category;
import EAM.Blogging.model.Post;

public class DtoPostCategory {
    private Post post;   // refencia del objeto
    private Category category;   // refencia del objeto

    public DtoPostCategory() {
        super();
    }

    public DtoPostCategory(Post post, Category category) {
        this.post = post;
        this.category = category;
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
