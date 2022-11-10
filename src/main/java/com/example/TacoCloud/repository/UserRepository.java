package com.example.TacoCloud.repository;

import com.example.TacoCloud.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
