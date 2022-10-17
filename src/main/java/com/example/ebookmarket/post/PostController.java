package com.example.ebookmarket.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/posts")
@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    @GetMapping("/create")
    public String postForm(Model model){
        model.addAttribute("postFormDto", new PostFormDto());
        return "post/postForm";

    }

    @GetMapping("/{postId}/modify")
    public String postModifyForm(@PathVariable("postId") Long postId, Model model){
        Post post = postService.getPostById(postId);
        PostFormDto postFormDto = new PostFormDto();
        model.addAttribute("postFormDto", postFormDto);
        return "post/postModifyForm";
    }

    @GetMapping("/list")
    public String postList(Model model){
        List<Post> postList = this.postService.getPost();
        model.addAttribute("postListList", postList);
        return "post/postList";
    }

    @PostMapping("/create")
    public String postCreate(PostFormDto postFormDto){
        postService.createPost(postFormDto);
        return "redirect:/posts/list";
    }

    @GetMapping("/{postId}/delete")
    public String postDelete(@PathVariable("postId") Long postId){
        Post post = postService.getPostById(postId);
        postService.deletePost(postId);
        return "redirect:/posts/list";
    }
}
