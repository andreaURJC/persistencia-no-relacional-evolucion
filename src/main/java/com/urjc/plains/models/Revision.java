package com.urjc.plains.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Revision {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "avionRevisado")
    private Avion avionRevisado;

    private Date fechaInicio;

    private Date fechaFin;

    private int duracionRevision;

    @ManyToOne
    @JoinColumn(name = "empleadoCargo")
    private Mecanico empleadoCargo;

    private String tipoRevision;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "aeropuertoRevision")
    private Aeropuerto aeropuertoRevision;

    public Revision(Avion avionRevisado, Date fechaInicio, Date fechaFin, int duracionRevision, Mecanico empleadoCargo, String tipoRevision, String descripcion, Aeropuerto aeropuertoRevision) {
        this.avionRevisado = avionRevisado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.duracionRevision = duracionRevision;
        this.empleadoCargo = empleadoCargo;
        this.tipoRevision = tipoRevision;
        this.descripcion = descripcion;
        this.aeropuertoRevision = aeropuertoRevision;
    }

    public Revision() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Avion getAvionRevisado() {
        return avionRevisado;
    }

    public void setAvionRevisado(Avion avionRevisado) {
        this.avionRevisado = avionRevisado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDuracionRevision() {
        return duracionRevision;
    }

    public void setDuracionRevision(int duracionRevision) {
        this.duracionRevision = duracionRevision;
    }

    public Mecanico getEmpleadoCargo() {
        return empleadoCargo;
    }

    public void setEmpleadoCargo(Mecanico empleadoCargo) {
        this.empleadoCargo = empleadoCargo;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public void setTipoRevision(String tipoRevision) {
        this.tipoRevision = tipoRevision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Aeropuerto getAeropuertoRevision() {
        return aeropuertoRevision;
    }

    public void setAeropuertoRevision(Aeropuerto aeropuertoRevision) {
        this.aeropuertoRevision = aeropuertoRevision;
    }
}
