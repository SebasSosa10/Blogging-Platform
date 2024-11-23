package EAM.Blogging.repository;

import EAM.Blogging.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositoryPost extends JpaRepository<Post, Long> {
    List<Post> findByTitle(String title);
    List<Post> findByUser_UserName(String userName);
}
