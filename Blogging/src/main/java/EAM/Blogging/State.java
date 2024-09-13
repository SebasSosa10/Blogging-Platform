package EAM.Blogging;

import jakarta.persistence.*;

@Entity
@Table(name = "State")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idState;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "state")
    private Post post;

    public State() {
        super();
    }

    public State(int idState, String name, Post post) {
        this.idState = idState;
        this.name = name;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }
}
