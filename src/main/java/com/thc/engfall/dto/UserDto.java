package com.thc.engfall.dto;

import com.thc.engfall.entity.User;
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
        String birth;
        String gender;

        public User toEntity(){
            return User.of(username, password, name, phone, birth, gender);
        }
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }

    @Getter @Setter @Builder
    public static class UpdateReqDto {
        Long id;

        String password;
        String name;
        String phone;
        String gender;
    }

    @Getter @Setter @Builder
    public static class DetailReqDto {
        Long id;
    }

    @Getter @Setter @Builder
    public static class DetailResDto {
        Long id;

        String username;
        String name;
        String phone;
        String birth;
        String gender;
    }
}
