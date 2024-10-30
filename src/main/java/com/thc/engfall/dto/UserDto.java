package com.thc.engfall.dto;

import lombok.*;

public class UserDto {

    @Getter @Setter @Builder
    public static class LoginReqDto {
        String username;
        String password;
    }

    @Getter @Setter @Builder
    public static class CreateReqDto {
        String username;
        String password;
        String name;
        String phone;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }
}
