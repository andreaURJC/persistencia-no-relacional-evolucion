package com.urjc.plains.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Revision {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "avion")
    private Avion avion;

    private Date fechaInicio;

    private Date fechaFin;

    private int horas;

    @ManyToOne
    @JoinColumn(name = "empleado")
    private Mecanico empleado;

    private String tipo;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "aeropuerto")
    private Aeropuerto aeropuerto;

    public Revision(Avion avion, Date fechaInicio, Date fechaFin, int horas, Mecanico empleado, String tipo, String descripcion, Aeropuerto aeropuerto) {
        this.avion = avion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horas = horas;
        this.empleado = empleado;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.aeropuerto = aeropuerto;
    }

    public Revision() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Mecanico getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Mecanico empleado) {
        this.empleado = empleado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }
}
