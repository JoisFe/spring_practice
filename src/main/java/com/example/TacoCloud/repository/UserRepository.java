package com.example.TacoCloud.repository;

import com.example.TacoCloud.domain.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
}
