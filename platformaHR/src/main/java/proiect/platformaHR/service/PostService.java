package proiect.platformaHR.service;

import org.springframework.stereotype.Service;
import proiect.platformaHR.entity.Post;
import proiect.platformaHR.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPost (Integer id){
        return postRepository.findById(id).get();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Integer id){
        postRepository.deleteById(id);
    }
}
