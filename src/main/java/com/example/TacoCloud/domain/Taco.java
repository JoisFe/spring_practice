package com.example.TacoCloud.domain;

import java.util.List;
import lombok.Getter;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
public class Taco {
    private String name;
    private List<String> ingredients;
}
