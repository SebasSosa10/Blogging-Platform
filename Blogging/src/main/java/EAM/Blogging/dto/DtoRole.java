package EAM.Blogging.dto;

import EAM.Blogging.model.User;
import jakarta.validation.constraints.*;

public class DtoRole {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    private User user; // Reference to the User object

    public DtoRole() {
        super();
    }

    public DtoRole(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



