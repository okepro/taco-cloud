package com.okepro.tacocloud.repositories;

import com.okepro.tacocloud.models.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
