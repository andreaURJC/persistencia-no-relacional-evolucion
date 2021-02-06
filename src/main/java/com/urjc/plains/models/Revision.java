package com.urjc.plains.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Revision {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avionRevisado;

    private Date fechaInicio;

    private Date fechaFin;

    private int duracionRevision;

    @ManyToOne
    @JoinColumn(name = "mecanico_id")
    private Mecanico empleadoCargo;

    private String tipoRevision;

    private String descripcionTrabajo;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_id")
    private Aeropuerto aeropuertoRevision;


    public Revision(Avion avionRevisado, Date fechaInicio, Date fechaFin, int duracionRevision, Mecanico empleadoCargo, String tipoRevision, String descripcionTrabajo, Aeropuerto aeropuertoRevision) {
        this.avionRevisado = avionRevisado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.duracionRevision = duracionRevision;
        this.empleadoCargo = empleadoCargo;
        this.tipoRevision = tipoRevision;
        this.descripcionTrabajo = descripcionTrabajo;
        this.aeropuertoRevision = aeropuertoRevision;
    }

    public Revision() {}
}
