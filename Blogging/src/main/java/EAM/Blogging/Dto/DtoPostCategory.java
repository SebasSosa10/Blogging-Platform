package EAM.Blogging.Dto;

import EAM.Blogging.Model.Category;
import EAM.Blogging.Model.Post;
import jakarta.persistence.*;

public class DtoPostCategory {
    private Post post;   // refencia del objeto
    private Category category;   // refencia del objeto

    public DtoPostCategory() {

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
