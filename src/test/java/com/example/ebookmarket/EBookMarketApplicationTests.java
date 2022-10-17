package com.example.ebookmarket;

import com.example.ebookmarket.post.Post;
import com.example.ebookmarket.post.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EBookMarketApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private PostRepository postRepository;
    @Test
    void testJpa(){
        Post p1 = new Post();
        p1.setContent("내용1");
        this.postRepository.save(p1);
    }

}
