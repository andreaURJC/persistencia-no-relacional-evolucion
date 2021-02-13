package com.urjc.plains.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue
    private Long codigoVuelo;

    private String compania;

    @ManyToOne
    @JoinColumn(name = "avion")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "aeropuertoOrigen")
    private Aeropuerto aeropuertoOrigen;

    @ManyToOne
    @JoinColumn(name = "aeropuertoDestino")
    private Aeropuerto aeropuertoDestino;

    private Date fechaHora;

    private Double duracion;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    private List<VueloTripulante> vuelosTripulantes;

    private String tripulantesJson;

    public Vuelo(String compania, Avion avion, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, Date fechaHora, Double duracion) {
        this.compania = compania;
        this.avion = avion;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.fechaHora = fechaHora;
        this.duracion = duracion;
    }

    public Vuelo() {}

    public Long getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(Long id) {
        this.codigoVuelo = id;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public List<VueloTripulante> getVuelosTripulantes() {
        return vuelosTripulantes;
    }

    public void setVuelosTripulantes(List<VueloTripulante> vuelosTripulantes) {
        this.vuelosTripulantes = vuelosTripulantes;
    }

    public String getTripulantesJson() {
        return tripulantesJson;
    }

    public void setTripulantesJson(String tripulantesJson) {
        this.tripulantesJson = tripulantesJson;
    }

    @Override
    public String toString() {

        return "Vuelo[ codigoVuelo: " + codigoVuelo +
                " | compania: " + compania +
                " | avion: " + avion.getModelo() +
                " | aeropuertoOrigen: " + aeropuertoOrigen.getIata() +
                " | aeropuertoDestino: " + aeropuertoDestino.getIata() +
                " | fechaHora: " + fechaHora +
                " | duracion: " + duracion + " ]";
    }
}
