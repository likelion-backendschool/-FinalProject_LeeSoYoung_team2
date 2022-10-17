package com.example.ebookmarket.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    }
}
