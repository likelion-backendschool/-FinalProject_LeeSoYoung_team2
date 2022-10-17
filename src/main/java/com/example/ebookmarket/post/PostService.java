package com.example.ebookmarket.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getPost(){
        return this.postRepository.findAll();
    }

    public void createPost(PostFormDto postFormDto) {
        Post post = postFormDto.createPost();
        postRepository.save(post);
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow(()->new EntityNotFoundException());
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
