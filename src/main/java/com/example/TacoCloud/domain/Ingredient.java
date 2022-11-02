package com.example.TacoCloud.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
