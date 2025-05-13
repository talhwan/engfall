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
    @Setter @Column(nullable = false) String type; // lost or found
    @Setter @Column(nullable = false) String cate; // wallet or ....
    @Setter @Column(nullable = false) String title;
    @Setter @Column(nullable = false) String location;
    @Setter @Column(nullable = false) String content;
    @Setter @Column(nullable = false) String img;

    protected Post(){}
    private Post(Boolean deleted, String type, String cate, String title, String location, String content, String img){
        this.deleted = deleted;
        this.type = type;
        this.cate = cate;
        this.title = title;
        this.location = location;
        this.content = content;
        this.img = img;
    }

    public static Post of(String type, String cate, String title, String location, String content, String img){
        return new Post(false, type, cate, title, location, content, img);
    }

    public PostDto.CreateResDto toCreateResDto(){
        return PostDto.CreateResDto.builder().id(getId()).build();
    }

}
