package com.thc.engfall.entity;

import com.thc.engfall.dto.PostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Setter @Column(nullable = false) Boolean deleted;
    @Setter @Column(nullable = false) String title;
    @Setter @Column(nullable = false) String content;
    @Setter @Column(nullable = false) Long userId;

    protected Post(){}
    private Post(Boolean deleted, String title, String content, Long userId){
        this.deleted = deleted;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public static Post of(String title, String content, Long userId){
        return new Post(false, title, content, userId);
    }

    public PostDto.CreateResDto toCreateResDto(){
        return PostDto.CreateResDto.builder().id(getId()).build();
    }

}
