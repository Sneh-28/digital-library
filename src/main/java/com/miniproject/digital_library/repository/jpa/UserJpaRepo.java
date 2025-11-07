package com.miniproject.digital_library.repository.jpa;

import com.miniproject.digital_library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<UserEntity,Integer> {
 Optional<UserEntity>findByEmail(String email);



}
