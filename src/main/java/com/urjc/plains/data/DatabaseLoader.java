package com.urjc.plains.data;

import com.urjc.plains.dtos.AvionesRevisadosDTO;
import com.urjc.plains.dtos.CiudadesOrigenTripulanteDTO;
import com.urjc.plains.dtos.ResumenVuelosTripulantesDTO;
import com.urjc.plains.dtos.VuelosPorCiudadDestinoYFechaDTO;
import com.urjc.plains.models.*;
import com.urjc.plains.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    VueloTripulanteRepository vueloTripulanteRepository;

    @Override
    public void run(String... args) {

        Mecanico mecanico1 = new Mecanico("Dionisio", "Alvarez", "Mecatron", 1995, "Modulo FP");
        Mecanico mecanico2 = new Mecanico("Antonio", "Gutierrez", "SuperAviones", 2003, "Grado en Aeronautica");

        mecanicoRepository.saveAll(Arrays.asList(mecanico1, mecanico2));
        List<Mecanico> mecanicos = mecanicoRepository.findAll();
        
        Avion avionJumbo = new Avion("B-0747", "Boeing", "747", 200);
        Avion avionAirbus = new Avion("A-0380", "Airbus Group", "A380", 550);
        
        avionRepository.saveAll(Arrays.asList(avionJumbo, avionAirbus));
        List<Avion> aviones = avionRepository.findAll();
        
        Aeropuerto aeropuertoLeon = new Aeropuerto("LEO", "Aeropuerto de Leon", "Leon", "ESP");
        Aeropuerto aeropuertoAlicante = new Aeropuerto("ALC","Aeropuerto de Alicante", "Alicante", "ESP");
        
        aeropuertoRepository.saveAll(Arrays.asList(aeropuertoAlicante, aeropuertoLeon));
        List<Aeropuerto> aeropuertos = aeropuertoRepository.findAll();
        
        Revision revision1 = new Revision(avionAirbus, null, null, 10, mecanico1, "anual", "montaje, motor, etc", aeropuertoAlicante);
        Revision revision2 = new Revision(avionJumbo, null, null, 10, mecanico2, "anual", "montaje, motor, etc", aeropuertoLeon);
        
        revisionRepository.saveAll(Arrays.asList(revision1, revision2));
        List<Revision> revisiones = revisionRepository.findAll();
        for (Revision revision : revisiones ) {
            revision.getAeropuerto();
            revision.getAvion();
            revision.getMecanico();
        }
        
        Tripulante tripulante1 = new Tripulante("Rafael", "Santos", "Iberia", "Azafato");
        Tripulante tripulante2 = new Tripulante("Ane", "Colina", "Emirates", "Azafata");
        
        Calendar cVuelo1 = Calendar.getInstance();
        Calendar cVuelo2 = Calendar.getInstance();
        cVuelo2.add(Calendar.MONTH, -2);
        
        Vuelo vuelo1 = new Vuelo("Iberia", avionJumbo, aeropuertoAlicante, aeropuertoLeon, cVuelo1.getTime(), 2.587);
        Vuelo vuelo2 = new Vuelo("Ryanair", avionAirbus, aeropuertoLeon, aeropuertoAlicante, cVuelo2.getTime(), 3.27);
        
        VueloTripulante v1t1 = new VueloTripulante(vuelo1,tripulante1);
        VueloTripulante v1t2 = new VueloTripulante(vuelo1,tripulante2);
        VueloTripulante v2t1 = new VueloTripulante(vuelo2,tripulante1);
        
        vuelo1.setTripulantes(Arrays.asList(v1t1,v1t2));
        vuelo2.setTripulantes(Arrays.asList(v2t1));
        
        vueloRepository.saveAll(Arrays.asList(vuelo1, vuelo2));
        
        List<Tripulante> tripulantes = tripulanteRepository.findAll();
        
        List<Vuelo> vuelos = vueloRepository.findAll();
        for (Vuelo vuelo : vuelos) {
            vuelo.getAeropuertoOrigen();
            vuelo.getAeropuertoDestino();
            vuelo.getAvion();
        }

        List<VueloTripulante> vuelosTripulantes = vueloTripulanteRepository.findAll();
        for (VueloTripulante vueloTripulante : vuelosTripulantes) {
            vueloTripulante.getTripulante();
            vueloTripulante.getVuelo();
        }
        
        System.out.println("Listado de mecánicos:");
        muestraDatos(mecanicos);
        
        System.out.println("Listado de aviones:");
        muestraDatos(aviones);
        
        System.out.println("Listado de aeropuertos:");
        muestraDatos(aeropuertos);
        
        System.out.println("Listado de revisiones:");
        muestraDatos(revisiones);
        
        System.out.println("Listado de tripulantes:");
        muestraDatos(tripulantes);
        
        System.out.println("Listado de vuelos:");
        muestraDatos(vuelos);

        System.out.println("Listado de vuelos:");
        muestraDatos(vuelosTripulantes);

        List<AvionesRevisadosDTO> avionesRevisados = mecanicoRepository.findAvionesWithMecanicos();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("-------------- Consulta 1 --------------");
        System.out.println("----------------------------------------");
        avionesRevisados.forEach(avion -> System.out.println(avion));
        System.out.println("----------------------------------------");
        System.out.println();

        String destino = "Leon";
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(cVuelo1.getTime());

        List<VuelosPorCiudadDestinoYFechaDTO> vuelosByDestino = vueloRepository.findVuelosByDestinoAndFecha(destino, strDate);
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("-------------- Consulta 2 --------------");
        System.out.println("----------------------------------------");
        System.out.println("Vuelos con destino " + destino + " para la fecha " + strDate + ":");
        vuelosByDestino.forEach(vuelo -> System.out.println(vuelo));
        System.out.println("----------------------------------------");
        System.out.println();

        Optional<Tripulante> tripulanteConsulta = tripulanteRepository.findAll().stream().findFirst();
        if (tripulanteConsulta.isPresent()) {
            Long codigoEmpleado = tripulanteConsulta.get().getCodigoEmpleado();
            List<CiudadesOrigenTripulanteDTO> ciudades = tripulanteRepository.findCiudadesOrigenByCodigoEmpleado(codigoEmpleado);
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("-------------- Consulta 3 --------------");
            System.out.println("----------------------------------------");
            if (ciudades.isEmpty()) {
                System.out.println("No se han encontrado vuelos para el código de empleado: " + codigoEmpleado + ".");
            } else {
                System.out.println("El tripulante con código de empleado: " + codigoEmpleado
                        + " (" + ciudades.get(0).getNombre() + " " + ciudades.get(0).getApellidos() + ")"
                        + " ha volado desde las siguientes ciudades:");
                ciudades.forEach(ciudad -> System.out.println(ciudad));
            }
        } else {
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("-------------- Consulta 3 --------------");
            System.out.println("----------------------------------------");
            System.out.println("No se ha encontrado ningún tripulante.");
        }
        System.out.println("----------------------------------------");
        System.out.println();


        List<ResumenVuelosTripulantesDTO> resumen = tripulanteRepository.findResumenVuelosTripulantes();
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("-------------- Consulta 4 --------------");
        System.out.println("----------------------------------------");
        resumen.forEach(tripulanteResumen -> System.out.println(tripulanteResumen));
        System.out.println("----------------------------------------");
        System.out.println();
    }

    private static void muestraDatos(List datos) {
        for (Object p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }
}
