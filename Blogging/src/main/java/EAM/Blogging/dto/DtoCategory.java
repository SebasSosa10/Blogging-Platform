package EAM.Blogging.dto;

import EAM.Blogging.model.PostCategory;
import jakarta.validation.constraints.*;

import java.util.List;

public class DtoCategory {
    @NotBlank(message = "Name cannot be empty")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;
    private List<PostCategory> postCategories;

    public DtoCategory() {
        super();
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
