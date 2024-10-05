package EAM.Blogging.dto;

import EAM.Blogging.model.Post;
import jakarta.validation.constraints.*;

public class DtoState {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    private Post post;

    public DtoState() {
        super();
    }

    public DtoState(String name, Post post) {
        this.name = name;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
}
