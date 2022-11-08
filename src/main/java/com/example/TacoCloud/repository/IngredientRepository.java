package com.example.TacoCloud.repository;

import com.example.TacoCloud.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
