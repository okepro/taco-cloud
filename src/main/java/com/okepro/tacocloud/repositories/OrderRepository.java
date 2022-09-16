package com.okepro.tacocloud.repositories;

import com.okepro.tacocloud.models.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
