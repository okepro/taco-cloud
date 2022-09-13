package com.okepro.tacocloud.repositories;

import com.okepro.tacocloud.models.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
