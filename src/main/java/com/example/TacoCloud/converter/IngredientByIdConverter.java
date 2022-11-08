package com.example.TacoCloud.converter;

import com.example.TacoCloud.domain.Ingredient;
import com.example.TacoCloud.repository.IngredientRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author : 조재철
 * @since 1.0
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        Optional<Ingredient> optionalIngredient = ingredientRepo.findById(id);

        return optionalIngredient.isPresent() ?
            optionalIngredient.get() : null;
    }
}
