package com.urjc.plains.repository;

import com.urjc.plains.models.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, Long> {
}
