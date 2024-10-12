package EAM.Blogging.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "User")
@Data
@Builder
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column (name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "biography")
    private String biography;

    @Column (name = "userName", unique = true, nullable = false)
    private String userName;

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

    public User(Long idUser, String email, String password, String biography, String userName, List<Post> posts, List<CommentS> comments, Role role) {
        this.idUser = idUser;
        this.email = email;
        this.password = password;
        this.biography = biography;
        this.userName = userName;
        this.posts = posts;
        this.comments = comments;
        this.role = role;
    }

    // Implementación de los métodos de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // Sin roles por simplicidad
    }

    //Gets And Setters Of Login
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //Getters And Setters From The Class
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

    @Override
    public String getUsername() {
        return userName;
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
}

