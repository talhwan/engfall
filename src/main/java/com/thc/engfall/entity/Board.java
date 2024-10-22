package com.thc.engfall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Board {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Setter
    String title;
    @Setter
    String content;
}
