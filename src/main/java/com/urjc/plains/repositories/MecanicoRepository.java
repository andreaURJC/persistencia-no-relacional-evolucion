package com.urjc.plains.repositories;

import com.urjc.plains.dtos.AvionesRevisadosDTO;
import com.urjc.plains.models.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

    @Query("SELECT DISTINCT new com.urjc.plains.dtos.AvionesRevisadosDTO(r.avion.matricula, m.nombre, m.apellidos) " +
            "FROM Mecanico m JOIN Revision r ON m.codigoEmpleado = r.mecanico.codigoEmpleado " +
            "ORDER BY 1, 2")
    List<AvionesRevisadosDTO> findAvionesWithMecanicos();

    @Query("SELECT new com.urjc.plains.dtos.AvionesRevisadosDTO(a.matricula, m.nombre, m.apellidos) " +
            "FROM Avion a JOIN Mecanico m ON FUNCTION('JSON_CONTAINS', FUNCTION('JSON_EXTRACT', a.revisionesJson ,'$[*].\"mecanico\"'), FUNCTION('CONVERT', m.codigoEmpleado, JSON), '$') = 1 " +
            "ORDER BY 1, 2")
    List<AvionesRevisadosDTO> findAvionesWithMecanicosJSON();
}
