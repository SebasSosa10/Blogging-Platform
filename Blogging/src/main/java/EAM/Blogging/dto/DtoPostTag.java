package EAM.Blogging.dto;

import EAM.Blogging.model.Post;
import EAM.Blogging.model.Tag;

public class DtoPostTag {
    private Post post;   // Referencia al objeto
    private Tag tag;   // Referencia al objeto

    public DtoPostTag() {
        super();
    }

    public DtoPostTag(Post post, Tag tag) {
        this.post = post;
        this.tag = tag;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
