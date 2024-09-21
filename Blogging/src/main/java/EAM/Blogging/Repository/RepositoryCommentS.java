package EAM.Blogging.Repository;

import EAM.Blogging.Model.CommentS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCommentS extends JpaRepository<CommentS, Long> {
}
