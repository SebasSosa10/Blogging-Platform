package EAM.Blogging.service;

import EAM.Blogging.dto.DtoPost;
import EAM.Blogging.model.Post;
import EAM.Blogging.model.PostCategory;
import EAM.Blogging.model.PostTag;
import EAM.Blogging.model.User;
import EAM.Blogging.repository.RepositoryPost;
import EAM.Blogging.repository.RepositoryPostCategory;
import EAM.Blogging.repository.RepositoryPostTag;
import EAM.Blogging.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServicePost {
    @Autowired
    private RepositoryPost postRepository;

    @Autowired
    private RepositoryUser userRepository;

    @Autowired
    private RepositoryPostCategory postCategoryRepository;

    @Autowired
    private RepositoryPostTag postTagRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(DtoPost dtoPost) {
        Post post = new Post();
        Optional<User> optionalUser = userRepository.findById(dtoPost.getUser().getIdUser());
        if(optionalUser.isPresent() && optionalUser.get().getRole().getName().equals("AUTHOR")){
            post.setTitle(dtoPost.getTitle());
            post.setContent(dtoPost.getContent());
            post.setPublisheddate(dtoPost.getPublisheddate());
            post.setUser(optionalUser.get());
            post.setIsPublished(dtoPost.isPublished());
            return postRepository.save(post);
        }
        return null;
    }

    public boolean updatePost(Long id, DtoPost dtoPost) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            if(optionalPost.get().getUser().equals(dtoPost.getUser())){
                Post postToUpdate = optionalPost.get();
                postToUpdate.setTitle(dtoPost.getTitle());
                postToUpdate.setContent(dtoPost.getContent());
                postToUpdate.setLikes(dtoPost.getLikes());
                postToUpdate.setPublisheddate(dtoPost.getPublisheddate());
                postToUpdate.setUser(dtoPost.getUser());
                postToUpdate.setIsPublished(dtoPost.isPublished());
                postRepository.save(postToUpdate);
                return true;
            }
        }
        return false;
    }

    public boolean deletePost(Long id, Long idUser) {
        Optional<User> optionalUser = userRepository.findById(idUser);
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalUser.isPresent() && optionalPost.isPresent() &&
                (optionalUser.get().equals(optionalPost.get().getUser()) || optionalUser.get().getRole().getName().equals("ADMIN"))) {
            postRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    //a
    public boolean changePostState(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post postToUpdate = optionalPost.get();
            postToUpdate.setIsPublished(!postToUpdate.getIsPublished());
            postRepository.save(postToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public Post addPostLike(Long idPost) {
        Optional<Post> optionalPost = postRepository.findById(idPost);
        if (optionalPost.isPresent()) {
            Post postToUpdate = optionalPost.get();
            postToUpdate.addLike();
            postRepository.save(postToUpdate);
            return optionalPost.get();
        } else {
            return null;
        }
    }

    public List<Post> searchPosts(String searchText) {
        Set<Post> resultSet = new HashSet<>();

        //Find by category
        List<PostCategory> postCategories = postCategoryRepository.findByCategory_Name(searchText);
        resultSet.addAll(postCategories.stream().map(PostCategory::getPost).collect(Collectors.toList()));

        //find by username
        resultSet.addAll(postRepository.findByUser_UserName(searchText));

        //find by tag name
        List<PostTag> postTags = postTagRepository.findByTag_Name(searchText);
        resultSet.addAll(postTags.stream().map(PostTag::getPost).collect(Collectors.toList()));

        //find by tittle
        resultSet.addAll(postRepository.findByTitle(searchText));

        return new ArrayList<>(resultSet);
    }
}
