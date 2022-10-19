package com.example.ebookmarket.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/post")
@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    @GetMapping("/write")
    public String postForm(Model model){
        model.addAttribute("postFormDto", new PostFormDto());
        return "post/postForm";

    }

    @GetMapping("/{postId}/modify")
    public String postModifyForm(@PathVariable("postId") Long postId, Model model){
        Post post = postService.getPostById(postId);
        PostModifyFormDto postModifyFormDto = new PostModifyFormDto();
        model.addAttribute("postModifyFormDto", postModifyFormDto);
        return "post/postModifyForm";
    }

    @PostMapping("/{postId}/modify")
    public String postModify(@Valid PostModifyFormDto postModifyFormDto, @PathVariable Long postId){

        this.postService.modifyPost(postModifyFormDto, postId);
        return "redirect:/post/list";
    }

    @RequestMapping(value="/{postId}")
    public String detail(Model model, @PathVariable("postId") Long postId){
        Post post = this.postService.getPostById(postId);
        model.addAttribute("post",post);
        return "post/postDetail";
    }

    @GetMapping("/list")
    public String postList(Model model){
        List<Post> postList = this.postService.getPost();
        model.addAttribute("postList", postList);
        return "post/postList";
    }

    @PostMapping("/write")
    public String postCreate(PostFormDto postFormDto){
        postService.createPost(postFormDto);
        return "redirect:/post/list";
    }

    @GetMapping("/{postId}/delete")
    public String postDelete(@PathVariable("postId") Long postId){
        Post post = postService.getPostById(postId);
        postService.deletePost(postId);
        return "redirect:/post/list";
    }

}
