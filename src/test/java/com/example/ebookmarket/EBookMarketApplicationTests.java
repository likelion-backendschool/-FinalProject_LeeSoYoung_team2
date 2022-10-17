package com.example.ebookmarket;

import com.example.ebookmarket.post.Post;
import com.example.ebookmarket.post.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class EBookMarketApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private PostRepository postRepository;
    @Test
    private void createSample() throws IOException {
        Post post = null;
        for(int i = 1; i <= 6; i++){
            post=Post.builder()
                    .title("title%s".formatted(i))
                    .content("content%s".formatted(i))
                    .writer("writer%s".formatted(i))
                    .views(1*i)
                    .build();
            postRepository.save(post);

        }
    }

}
