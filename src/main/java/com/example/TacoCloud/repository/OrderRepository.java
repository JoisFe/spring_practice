package com.example.TacoCloud.repository;

import com.example.TacoCloud.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

}
