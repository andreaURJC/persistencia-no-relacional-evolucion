package com.urjc.plains.repositories;

import com.urjc.plains.dtos.AvionesRevisadosDTO;
import com.urjc.plains.dtos.VuelosPorCiudadDestinoYFechaDTO;
import com.urjc.plains.models.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    @Query("SELECT new com.urjc.plains.dtos.VuelosPorCiudadDestinoYFechaDTO(v.codigoVuelo, v.compania, v.aeropuertoOrigen.iata, v.aeropuertoDestino.iata, v.fechaHora, v.duracion)" +
            "FROM Vuelo v JOIN Aeropuerto a ON v.aeropuertoDestino.iata = a.iata WHERE a.ciudad LIKE :ciudadDestino AND FUNCTION('date_format', v.fechaHora, '%d-%m-%Y') = :fecha ORDER BY FUNCTION('date_format', v.fechaHora, '%H')")
    List<VuelosPorCiudadDestinoYFechaDTO> findVuelosByDestinoAndFecha(@Param("ciudadDestino") String ciudadDestino, @Param("fecha") String fecha);
}