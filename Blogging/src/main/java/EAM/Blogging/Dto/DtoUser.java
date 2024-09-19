package EAM.Blogging.Dto;

import EAM.Blogging.Model.CommentS;
import EAM.Blogging.Model.Post;
import EAM.Blogging.Model.Role;
import EAM.Blogging.Model.UserProfile;
import jakarta.persistence.*;

import java.util.List;

public class DtoUser {
    private String email;
    private String password;
    private UserProfile userProfile;
    private List<Post> posts;
    private List<CommentS> comments;
    private Role role;

    public DtoUser() {

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

