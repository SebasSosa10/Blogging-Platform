package EAM.Blogging.dto;

import EAM.Blogging.model.User;
import jakarta.validation.constraints.*;

public class DtoUserProfile {
    @Size(max = 500, message = "Biography cannot exceed 500 characters")
    private String biography;
    @NotBlank(message = "Username cannot be empty")
    @Size(max = 30, message = "Username cannot exceed 30 characters")
    private String userName;
    private User user;

    public DtoUserProfile() {
        super();
    }

    public DtoUserProfile(User user, String userName, String biography) {
        this.user = user;
        this.userName = userName;
        this.biography = biography;
    }

    public String getBiography() {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}