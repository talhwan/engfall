package com.thc.engfall.dto;

import com.thc.engfall.entity.Postimg;
import lombok.*;

import java.util.List;

public class PostimgDto {

    @Getter @Setter @Builder
    public static class CreateReqDto {
        String url;
        Long postId;

        public Postimg toEntity(){
            return Postimg.of(url, postId);
        }
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }

    @Getter @Setter @Builder
    public static class UpdateReqDto {
        Long id;

        String url;
        Long postId;
    }

    @Getter @Setter @Builder
    public static class DetailReqDto {
        Long id;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;

        String url;
        Long postId;
    }

    @Getter @Setter @Builder
    public static class ListReqDto {
        Boolean deleted;
        Long postId;
    }
}
