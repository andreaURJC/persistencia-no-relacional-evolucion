package com.urjc.plains.data;

import com.urjc.plains.dtos.AvionesRevisadosDTO;
import com.urjc.plains.models.*;
import com.urjc.plains.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
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

        Mecanico mecanico1 = new Mecanico("Dionisio", "Alvarez", "Mecatron", 1995, "Modulo FP");
        Mecanico mecanico2 = new Mecanico("Antonio", "Gutierrez", "SuperAviones", 2003, "Grado en Aeronautica");

        mecanicoRepository.saveAll(Arrays.asList(mecanico1, mecanico2));

        Avion avionJumbo = new Avion("B-0747", "Boeing", "747", 200);
        Avion avionAirbus = new Avion("A-0380", "Airbus Group", "A380", 550);

        avionRepository.saveAll(Arrays.asList(avionJumbo, avionAirbus));

        Aeropuerto aeropuertoLeon = new Aeropuerto("LEO", "Aeropuerto de Leon", "Leon", "ESP");
        Aeropuerto aeropuertoAlicante = new Aeropuerto("ALC","Aeropuerto de Alicante", "Alicante", "ESP");

        aeropuertoRepository.saveAll(Arrays.asList(aeropuertoAlicante, aeropuertoLeon));

        Revision revision1 = new Revision(avionAirbus, null, null, 10, mecanico1, "anual", "montaje, motor, etc", aeropuertoAlicante);
        Revision revision2 = new Revision(avionJumbo, null, null, 10, mecanico2, "anual", "montaje, motor, etc", aeropuertoLeon);

        revisionRepository.saveAll(Arrays.asList(revision1, revision2));

        Tripulante tripulante1 = new Tripulante("Rafael", "Santos", "Iberia", "Azafato");
        Tripulante tripulante2 = new Tripulante("Ane", "Colina", "Emirates", "Azafata");

        Vuelo vuelo1 = new Vuelo("Iberia", avionJumbo, aeropuertoAlicante, aeropuertoLeon, null, 2.587);
        Vuelo vuelo2 = new Vuelo("Ryanair", avionAirbus, aeropuertoLeon, aeropuertoAlicante, null, 3.27);

        VueloTripulante v1t1 = new VueloTripulante(vuelo1,tripulante1);
        VueloTripulante v1t2 = new VueloTripulante(vuelo1,tripulante2);
        VueloTripulante v2t1 = new VueloTripulante(vuelo2,tripulante1);

        vuelo1.setTripulantes(Arrays.asList(v1t1,v1t2));
        vuelo2.setTripulantes(Arrays.asList(v2t1));

        vueloRepository.saveAll(Arrays.asList(vuelo1, vuelo2));

        List<AvionesRevisadosDTO> avionesRevisados = mecanicoRepository.findAvionesWithMecanicos();

        System.out.println("----------------------------------------");
        System.out.println("-------------- Consulta 1 --------------");
        System.out.println("----------------------------------------");
        avionesRevisados.forEach(avion -> System.out.println(avion));
        System.out.println("----------------------------------------");

    }
}
