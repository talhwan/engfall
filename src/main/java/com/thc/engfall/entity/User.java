package com.thc.engfall.entity;

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

    @Setter @Column(nullable = false) String username;
    @Setter @Column(nullable = false) String password;
    @Setter @Column(nullable = false) String name;
    @Setter String phone;
    @Setter String birth;
    @Setter String gender;
}
