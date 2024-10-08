package com.thc.engfall.repository;

import com.thc.engfall.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepositiry extends JpaRepository<Board, Long> {
}
