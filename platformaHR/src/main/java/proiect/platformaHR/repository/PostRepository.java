package proiect.platformaHR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proiect.platformaHR.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
