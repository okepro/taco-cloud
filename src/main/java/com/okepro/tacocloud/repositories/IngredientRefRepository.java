package com.okepro.tacocloud.repositories;

import com.okepro.tacocloud.models.Ingredient;

import java.util.List;

public interface IngredientRefRepository {
    void saveIngredientRefs(long tacoId, List<Ingredient> ingredient);
}
