package com.okepro.tacocloud.web;

import com.okepro.tacocloud.models.Ingredient;
import com.okepro.tacocloud.repositories.JdbcIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import com.okepro.tacocloud.models.Ingredient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final JdbcIngredientRepository jdbcIngredientRepository;

    @Autowired
    public IngredientByIdConverter(JdbcIngredientRepository jdbcIngredientRepository) {
        this.jdbcIngredientRepository = jdbcIngredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return jdbcIngredientRepository.findById(id).orElse(null);
    }
}
