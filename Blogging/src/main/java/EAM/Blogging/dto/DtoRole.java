package EAM.Blogging.dto;

import EAM.Blogging.model.User;
import jakarta.validation.constraints.*;

public class DtoRole {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    public DtoRole() {
        super();
    }

    public DtoRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}



