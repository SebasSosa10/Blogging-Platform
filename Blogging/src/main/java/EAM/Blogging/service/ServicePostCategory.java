package EAM.Blogging.service;

import EAM.Blogging.dto.DtoPostCategory;
import EAM.Blogging.model.PostCategory;
import EAM.Blogging.repository.RepositoryPostCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePostCategory {
    @Autowired
    private RepositoryPostCategory postCategoryRepository;

    public List<PostCategory> findAllPostCategories() {
        return postCategoryRepository.findAll();
    }

    public PostCategory findPostCategoryById(Long id) {
        return postCategoryRepository.findById(id).orElse(null);
    }

    public PostCategory createPostCategory(DtoPostCategory dtoPostCategory) {
        PostCategory postCategory = new PostCategory();
        postCategory.setPost(dtoPostCategory.getPost());
        postCategory.setCategory(dtoPostCategory.getCategory());
        return postCategoryRepository.save(postCategory);
    }

    public boolean updatePostCategory(Long id, DtoPostCategory dtoPostCategory) {
        Optional<PostCategory> optionalPostCategory = postCategoryRepository.findById(id);
        if (optionalPostCategory.isPresent()) {
            PostCategory postCategoryToUpdate = optionalPostCategory.get();
            postCategoryToUpdate.setPost(dtoPostCategory.getPost());
            postCategoryToUpdate.setCategory(dtoPostCategory.getCategory());
            postCategoryRepository.save(postCategoryToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePostCategory(Long id) {
        if (postCategoryRepository.existsById(id)) {
            postCategoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
