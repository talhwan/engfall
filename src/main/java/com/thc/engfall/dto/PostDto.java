package com.thc.engfall.dto;

import com.thc.engfall.entity.Post;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

public class PostDto {

    @Getter @Setter @Builder
    public static class CreateReqDto {
        String type;
        String cate;
        String title;
        String location;
        String content;
        String img;
        List<String> imgs;

        public Post toEntity(){
            return Post.of(getType(), getCate(), getTitle(), getLocation(), getContent(), getImg());
        }
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }

    @Getter @Setter @Builder
    public static class UpdateReqDto {
        Long id;

        String title;
        String content;
    }

    @Getter @Setter @Builder
    public static class DetailReqDto {
        Long id;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;

        String type;
        String cate;
        String title;
        String location;
        String content;
        String img;

        //List<String> imgs;
        List<PostimgDto.DetailResDto> imgs;
    }


    @Getter @Setter @Builder
    public static class ListReqDto {
        Boolean deleted;
        String title;

        String type;
        String cate;
    }

    @Getter @Setter @Builder
    public static class PagedListReqDto {
        Integer offset; // first order!!
        Integer callpage;
        Integer perpage;

        Boolean deleted;
        String title;

        String type;
        String cate;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListResDto {
        Integer callpage;
        Integer perpage;
        Integer listsize;
        Integer totalpage;

        List<DetailResDto> list;
    }


    @Getter @Setter @Builder
    public static class ScrollListReqDto {
        Object cursor;
        Integer perpage;

        Boolean deleted;
        String title;

        String type;
        String cate;
    }
}
