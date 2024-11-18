package EAM.Blogging.dto;

import EAM.Blogging.model.PostTag;
import jakarta.validation.constraints.*;

import java.util.List;

public class DtoTag {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    public DtoTag() {
        super();
    }

    public DtoTag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
