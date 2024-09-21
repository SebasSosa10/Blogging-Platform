package EAM.Blogging.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "State")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idState;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "state")
    private Post post;

    public State() {
        super();
    }

    public State(String name, Post post) {
        this.name = name;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
