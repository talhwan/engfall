package com.thc.engfall.repository;

import com.thc.engfall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositiry extends JpaRepository<User, Long> {
}
