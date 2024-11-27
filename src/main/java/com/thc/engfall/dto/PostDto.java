package com.thc.engfall.dto;

import com.thc.engfall.entity.Post;
import lombok.*;

public class PostDto {

    @Getter @Setter @Builder
    public static class CreateReqDto {
        String title;
        String content;
        Long userId;

        public Post toEntity(){
            return Post.of(title, content, userId);
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
        Long userId;
    }

    @Getter @Setter @Builder
    public static class DetailReqDto {
        Long id;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;

        String title;
        String content;
        Long userId;

        String userUsername;
        String userName;
        String userPhone;
    }


    @Getter @Setter @Builder
    public static class ListReqDto {
        Boolean deleted;
        String title;
        Long userId;
    }
}
