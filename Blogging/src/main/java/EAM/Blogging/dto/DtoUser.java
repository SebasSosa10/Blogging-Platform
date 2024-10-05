package EAM.Blogging.dto;

import EAM.Blogging.model.CommentS;
import EAM.Blogging.model.Post;
import EAM.Blogging.model.Role;
import EAM.Blogging.model.UserProfile;
import jakarta.validation.constraints.*;

import java.util.List;

public class DtoUser {
    @Email(message = "Email must be a valid email address")
    @NotEmpty(message = "Email field must be filled out")
    private String email;
    @NotEmpty(message = "Password field must be filled out")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
    private UserProfile userProfile;
    private List<Post> posts;
    private List<CommentS> comments;
    private Role role;

    public DtoUser() {
        super();
    }

    public DtoUser(Role role, List<CommentS> comments, List<Post> posts, UserProfile userProfile, String password, String email) {
        this.role = role;
        this.comments = comments;
        this.posts = posts;
        this.userProfile = userProfile;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<CommentS> getComments() {
        return comments;
    }

    public void setComments(List<CommentS> comments) {
        this.comments = comments;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}

