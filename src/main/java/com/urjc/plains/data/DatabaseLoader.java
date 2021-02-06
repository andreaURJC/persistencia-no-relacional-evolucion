package com.urjc.plains.data;

import com.urjc.plains.models.*;
import com.urjc.plains.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Cargador de la BD y resultado de las consultas
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    TripulanteRepository tripulanteRepository;

    @Autowired
    MecanicoRepository mecanicoRepository;

    @Autowired
    VueloRepository vueloRepository;

    @Autowired
    AvionRepository avionRepository;

    @Autowired
    RevisionRepository revisionRepository;

    @Autowired
    AeropuertoRepository aeropuertoRepository;

    @Override
    public void run(String... args) {
        Mecanico mecanico1 = new Mecanico("Dionisio", "Alvarez", "Mecatron", 1234, 1995, "Modulo FP");
        Mecanico mecanico2 = new Mecanico("Antonio", "Gutierrez", "SuperAviones", 0023, 2003, "Grado en Aeronautica");

        Aeropuerto aeropuertoLeon = new Aeropuerto("Aeropuerto de Leon", "Leon", "ESP");
        Aeropuerto aeropuertoAlicante = new Aeropuerto("Aeropuerto de Alicante", "Alicante", "ESP");

        Avion avionJumbo = new Avion("Boeing", "747", 200);
        Avion avionAirbus = new Avion("Airbus Group", "A380", 550);

        Revision revision1 = new Revision(avionAirbus, null, null, 10, mecanico1, "anual", "montaje, motor, etc", aeropuertoAlicante);
        Revision revision2 = new Revision(avionJumbo, null, null, 10, mecanico2, "anual", "montaje, motor, etc", aeropuertoLeon);

        Tripulante tripulante1 = new Tripulante("Rafael", "Santos", "Iberia", 0010, "Azafato");
        Tripulante tripulante2 = new Tripulante("Ane", "Colina", "Emirates", 0020, "Azafata");

        Vuelo vuelo1 = new Vuelo("Iberia", avionJumbo, aeropuertoAlicante, aeropuertoLeon, null, 2);
        Vuelo vuelo2 = new Vuelo("Ryanair", avionAirbus, aeropuertoLeon, aeropuertoAlicante, null, 2);

        VueloTripulante v1t1 = new VueloTripulante(vuelo1,tripulante1);
        VueloTripulante v1t2 = new VueloTripulante(vuelo1,tripulante2);
        VueloTripulante v2t1 = new VueloTripulante(vuelo2,tripulante1);

        vuelo1.setTripulantes(Arrays.asList(v1t1,v1t2));
        vuelo2.setTripulantes(Arrays.asList(v2t1));

        tripulanteRepository.saveAll(Arrays.asList(tripulante1, tripulante2));
        mecanicoRepository.saveAll(Arrays.asList(mecanico1, mecanico2));
        vueloRepository.saveAll(Arrays.asList(vuelo1, vuelo2));
        avionRepository.saveAll(Arrays.asList(avionAirbus, avionAirbus));
        revisionRepository.saveAll(Arrays.asList(revision1, revision2));
        aeropuertoRepository.saveAll(Arrays.asList(aeropuertoAlicante, aeropuertoLeon));
    }
}
