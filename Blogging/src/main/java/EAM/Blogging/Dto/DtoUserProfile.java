package EAM.Blogging.Dto;

import jakarta.persistence.*;

@Entity
@Table(name = "UserProfile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserProfile;

    @Column(name = "biography")
    private String biography;

    @Column (name = "userName")
    private String userName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public UserProfile() {
        super();
    }

    public UserProfile(int idUserProfile, User user, String userName, String biography) {
        this.idUserProfile = idUserProfile;
        this.user = user;
        this.userName = userName;
        this.biography = biography;
    }

    public int getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(int idUserProfile) {
        this.idUserProfile = idUserProfile;
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
