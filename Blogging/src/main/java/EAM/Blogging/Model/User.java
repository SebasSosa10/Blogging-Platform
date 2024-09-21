package EAM.Blogging.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column (name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)   //referencia de una llave foranea en algun lugar   cascada: si elimna un hotel las habitaciones existentes se eliminan
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)   //referencia de una llave foranea en algun lugar   cascada: si elimna un hotel las habitaciones existentes se eliminan
    private List<CommentS> comments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;



    public User() {
        super();
    }

    public User(Role role, List<CommentS> comments, List<Post> posts, UserProfile userProfile, String password, String email) {
        this.role = role;
        this.comments = comments;
        this.posts = posts;
        this.userProfile = userProfile;
        this.password = password;
        this.email = email;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

