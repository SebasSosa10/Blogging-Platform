package EAM.Blogging.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Userfollow")
public class UserFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserfollow;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "follower_id")
    private User follower;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "followed_id")
    private User followed;

    public UserFollow() {
        super();
    }

    public UserFollow(User follower, User followed) {
        this.follower = follower;
        this.followed = followed;
    }


    public Long getIdUserfollow() {
        return idUserfollow;
    }

    public void setIdUserfollow(Long idUserfollow) {
        this.idUserfollow = idUserfollow;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

}
