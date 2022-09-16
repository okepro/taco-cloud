package com.okepro.tacocloud.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.math.BigInteger;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class IngredientRef {
    @Id
    private final Long id;

    private final String ingredient;

    private final BigInteger taco;

    private final BigInteger taco_key;
}
