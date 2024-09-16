package EAM.Blogging;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTag;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<PostTag> postTags;

    public Tag() {
        super();
    }

    public Tag(int idTag, String name, List<PostTag> postTags) {
        this.idTag = idTag;
        this.name = name;
        this.postTags = postTags;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }
}
