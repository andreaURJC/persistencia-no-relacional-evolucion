package com.urjc.plains.repositories;

import com.urjc.plains.models.VueloTripulante;
import com.urjc.plains.models.VueloTripulanteId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloTripulanteRepository extends JpaRepository<VueloTripulante, VueloTripulanteId> {
    
}
