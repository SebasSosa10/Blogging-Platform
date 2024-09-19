package EAM.Blogging.Dto;

import EAM.Blogging.Model.PostCategory;
import jakarta.persistence.*;

import java.util.List;

public class DtoCategory {
    private String name;
    private String description;
    private List<PostCategory> postCategories;

    public DtoCategory() {

    }

    public DtoCategory(String name, String description, List<PostCategory> postCategories) {
        this.name = name;
        this.description = description;
        this.postCategories = postCategories;
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
