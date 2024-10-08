package com.thc.engfall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board {

    @Id
    Long id;

    String title;
    String content;
    String content2;
}
