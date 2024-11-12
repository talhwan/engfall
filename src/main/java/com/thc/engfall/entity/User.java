package com.thc.engfall.entity;

import com.thc.engfall.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Setter @Column(nullable = false) Boolean deleted;
    @Setter @Column(nullable = false, unique = true) String username;
    @Setter @Column(nullable = false) String password;
    @Setter @Column(nullable = false) String name;
    @Setter String phone;
    @Setter String birth;
    @Setter String gender;

    protected User(){}
    private User(Boolean deleted, String username, String password, String name, String phone, String birth, String gender){
        this.deleted = deleted;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.gender = gender;
    }

    public static User of(String username, String password, String name, String phone, String birth, String gender){
        return new User(false, username, password, name, phone, birth, gender);
    }

    public UserDto.CreateResDto toCreateResDto(){
        return UserDto.CreateResDto.builder().id(getId()).build();
    }

}
