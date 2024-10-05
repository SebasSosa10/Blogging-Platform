package EAM.Blogging.dto;

import EAM.Blogging.model.User;

public class DtoUserFollow {
    private User follower;
    private User followed;

    public DtoUserFollow() {
        super();
    }

    public DtoUserFollow(User follower, User followed) {
        this.follower = follower;
        this.followed = followed;
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
