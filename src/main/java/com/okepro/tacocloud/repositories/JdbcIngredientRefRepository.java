package com.okepro.tacocloud.repositories;

import com.okepro.tacocloud.models.Ingredient;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcIngredientRefRepository implements IngredientRefRepository {

    private final JdbcOperations jdbcOperations;

    public JdbcIngredientRefRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    @Override
    public void saveIngredientRefs(long tacoId, List<Ingredient> ingredient) {
        int key = 0;
        for (Ingredient ingredientRef : ingredient) {
            jdbcOperations.update(
                    "insert into Ingredient_Ref (ingredient, taco, taco_key) "
                            + "values (?, ?, ?)",
                    ingredientRef.getId(), tacoId, key++);
        }
    }
}
