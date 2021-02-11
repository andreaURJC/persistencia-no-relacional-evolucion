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

        List<Mecanico> mecanicos = mecanicoRepository.findAll();
        List<Avion> aviones = avionRepository.findAll();
        List<Aeropuerto> aeropuertos = aeropuertoRepository.findAll();
        List<Revision> revisiones = revisionRepository.findAll();
        List<Tripulante> tripulantes = tripulanteRepository.findAll();

        List<Vuelo> vuelos = vueloRepository.findAll();
        List<VueloTripulante> vuelosTripulantes = vueloTripulanteRepository.findAll();

        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("----------- Datos insertados ------------");
        System.out.println("-----------------------------------------");

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
        Vuelo vuelo1 = vueloRepository.findById(100L).get();
        String strDate = dateFormat.format(vuelo1.getFechaHora());

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
