package com.example.ebookmarket.post;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostModifyFormDto {
    private Long id;

    private String title;

    private String content;

    private String writer;

    private String file;

    public Post modifyPost(){
        return Post.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
