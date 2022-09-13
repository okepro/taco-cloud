package com.okepro.tacocloud.repositories;

import com.okepro.tacocloud.models.Taco;

public interface TacoRepository {
    long saveTaco(Long orderId, int orderKey, Taco taco);
}
