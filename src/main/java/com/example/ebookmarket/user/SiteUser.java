package com.example.ebookmarket.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @Column(unique = true)
    private String username;

    private String password;

    private String nickname;

    @Column(unique = true)
    private String email;

    private int authLevel;

}
