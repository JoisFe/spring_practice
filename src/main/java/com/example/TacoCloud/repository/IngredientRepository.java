package com.example.TacoCloud.repository;

import com.example.TacoCloud.domain.Ingredient;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
