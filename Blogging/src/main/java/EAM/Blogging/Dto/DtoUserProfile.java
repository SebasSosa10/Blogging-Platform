package EAM.Blogging.Dto;

import EAM.Blogging.Model.User;

public class DtoUserProfile {
    private String biography;
    private String userName;
    private User user;

    public DtoUserProfile() {

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