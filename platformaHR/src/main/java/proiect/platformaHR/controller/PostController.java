package proiect.platformaHR.controller;

import org.springframework.web.bind.annotation.*;
import proiect.platformaHR.entity.Post;
import proiect.platformaHR.repository.PostRepository;
import proiect.platformaHR.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPost (@PathVariable("id") Integer id){
      return postService.getPost(id);
    }
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Integer id){
        postService.deletePost(id);
    }
}
