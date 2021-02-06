package com.urjc.plains.repositories;

import com.urjc.plains.dtos.AvionesRevisadosDTO;
import com.urjc.plains.models.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

    @Query("SELECT DISTINCT new com.urjc.plains.dtos.AvionesRevisadosDTO(r.avion.matricula, m.nombre, m.apellidos)" +
            "FROM Mecanico m JOIN Revision r ON m.codigoEmpleado = r.mecanico.codigoEmpleado")
    List<AvionesRevisadosDTO> findAvionesWithMecanicos();
}
