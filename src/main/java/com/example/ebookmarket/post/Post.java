package com.example.ebookmarket.post;

import com.example.ebookmarket.user.SiteUser;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String writer;

    private String file;

    private int views;

    @ManyToOne
    private SiteUser siteUser;


}
