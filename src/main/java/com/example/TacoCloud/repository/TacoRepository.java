package com.example.TacoCloud.repository;

import com.example.TacoCloud.domain.Taco;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
