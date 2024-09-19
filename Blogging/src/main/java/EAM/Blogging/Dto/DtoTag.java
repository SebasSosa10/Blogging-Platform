package EAM.Blogging.Dto;

import EAM.Blogging.Model.PostTag;
import jakarta.persistence.*;

import java.util.List;

public class DtoTag {
    private String name;
    private List<PostTag> postTags;

    public DtoTag() {

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
