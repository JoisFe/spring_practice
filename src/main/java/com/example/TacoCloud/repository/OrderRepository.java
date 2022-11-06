package com.example.TacoCloud.repository;

import com.example.TacoCloud.domain.Order;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface OrderRepository {
    Order save(Order order);
}
