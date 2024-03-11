package proiect.platformaHR.controller;

import org.springframework.web.bind.annotation.*;
import proiect.platformaHR.entity.Post;
import proiect.platformaHR.repository.PostRepository;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getPost (@PathVariable("id") Integer id){
      return postRepository.findById(id).get();
    }
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Integer id){
        postRepository.deleteById(id);
    }
}
