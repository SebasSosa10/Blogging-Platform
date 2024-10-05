package EAM.Blogging.dto;

import EAM.Blogging.model.PostTag;
import jakarta.validation.constraints.*;

import java.util.List;

public class DtoTag {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    private List<PostTag> postTags;

    public DtoTag() {
        super();
    }

    public DtoTag(String name, List<PostTag> postTags) {
        this.name = name;
        this.postTags = postTags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }
}
