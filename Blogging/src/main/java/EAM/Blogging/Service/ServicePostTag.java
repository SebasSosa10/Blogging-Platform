package EAM.Blogging.Service;

import EAM.Blogging.Dto.DtoPostTag;
import EAM.Blogging.Model.PostTag;
import EAM.Blogging.Repository.RepositoryPostTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePostTag {

    @Autowired
    private RepositoryPostTag postTagRepository;

    public List<PostTag> findAllPostTags() {
        return postTagRepository.findAll();
    }

    public PostTag findPostTagById(Long id) {
        return postTagRepository.findById(id).orElse(null);
    }

    public PostTag createPostTag(DtoPostTag dtoPostTag) {
        PostTag postTag = new PostTag();
        postTag.setPost(dtoPostTag.getPost());
        postTag.setTag(dtoPostTag.getTag());
        return postTagRepository.save(postTag);
    }

    public boolean updatePostTag(Long id, DtoPostTag dtoPostTag) {
        Optional<PostTag> optionalPostTag = postTagRepository.findById(id);
        if (optionalPostTag.isPresent()) {
            PostTag postTagToUpdate = optionalPostTag.get();
            postTagToUpdate.setPost(dtoPostTag.getPost());
            postTagToUpdate.setTag(dtoPostTag.getTag());
            postTagRepository.save(postTagToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePostTag(Long id) {
        if (postTagRepository.existsById(id)) {
            postTagRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
