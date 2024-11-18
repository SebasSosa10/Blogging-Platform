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

    public DtoCategory() {
        super();
    }

    public DtoCategory(String name, String description) {
        this.name = name;
        this.description = description;
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
}
