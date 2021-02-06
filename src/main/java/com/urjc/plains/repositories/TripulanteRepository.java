package com.urjc.plains.repositories;

import com.urjc.plains.dtos.CiudadesOrigenTripulanteDTO;
import com.urjc.plains.dtos.ResumenVuelosTripulantesDTO;
import com.urjc.plains.dtos.VuelosPorCiudadDestinoYFechaDTO;
import com.urjc.plains.models.Tripulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripulanteRepository extends JpaRepository<Tripulante, Long> {

    @Query("SELECT new com.urjc.plains.dtos.CiudadesOrigenTripulanteDTO(t.nombre, t.apellidos, a.ciudad, v.fechaHora)" +
            "FROM Tripulante t JOIN VueloTripulante vt ON t.codigoEmpleado = vt.id.tripulanteId JOIN Vuelo v ON vt.id.vueloId = v.codigoVuelo JOIN Aeropuerto a ON v.aeropuertoOrigen.iata = a.iata WHERE t.codigoEmpleado = :codigoEmpleado")
    List<CiudadesOrigenTripulanteDTO> findCiudadesOrigenByCodigoEmpleado(@Param("codigoEmpleado") Long codigoEmpleado);


    @Query("SELECT new com.urjc.plains.dtos.ResumenVuelosTripulantesDTO(t.nombre, t.apellidos, COUNT(v.codigoVuelo), SUM(v.duracion))" +
            "FROM Tripulante t JOIN VueloTripulante vt ON t.codigoEmpleado = vt.id.tripulanteId JOIN Vuelo v ON vt.id.vueloId = v.codigoVuelo GROUP BY t.nombre, t.apellidos")
    List<ResumenVuelosTripulantesDTO> findResumenVuelosTripulantes();
}
