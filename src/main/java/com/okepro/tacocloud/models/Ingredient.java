package com.okepro.tacocloud.models;

import lombok.Data;

import java.util.Date;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;
    private Date createdAt = new Date();

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
