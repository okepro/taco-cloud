package com.okepro.tacocloud.repositories;

import com.okepro.tacocloud.models.Taco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacoRepository extends JpaRepository<Taco, Long> {

}
