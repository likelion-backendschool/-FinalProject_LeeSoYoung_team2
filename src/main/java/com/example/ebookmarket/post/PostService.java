package com.example.ebookmarket.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        Optional<Post> post = this.postRepository.findById(postId);
        if(post.isPresent()){
            return post.get();
        }else{
            throw new DataNotFoundException("question not found");
        }

    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
