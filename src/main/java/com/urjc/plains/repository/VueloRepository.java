package com.urjc.plains.repository;

import com.urjc.plains.models.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
}
