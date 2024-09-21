package EAM.Blogging.Model;

import jakarta.persistence.*;

@Entity
@Table(name ="Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "role")
    private User user;

    public Role() {
        super();
    }

    public Role(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return idRole;
    }

    public void setId(Long idRole) {
        this.idRole= idRole;
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



