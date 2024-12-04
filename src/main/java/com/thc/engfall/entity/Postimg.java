package com.thc.engfall.entity;

import com.thc.engfall.dto.PostimgDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Postimg {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Setter @Column(nullable = false) Boolean deleted;
    @Setter @Column(nullable = false) String url;
    @Setter @Column(nullable = false) Long postId;

    protected Postimg(){}
    private Postimg(Boolean deleted, String url, Long postId){
        this.deleted = deleted;
        this.url = url;
        this.postId = postId;
    }

    public static Postimg of(String url, Long postId){
        return new Postimg(false, url, postId);
    }

    public PostimgDto.CreateResDto toCreateResDto(){
        return PostimgDto.CreateResDto.builder().id(getId()).build();
    }

}
