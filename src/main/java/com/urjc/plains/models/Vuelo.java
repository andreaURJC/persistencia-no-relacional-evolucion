package com.urjc.plains.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue
    private Long id;

    private String company;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_id", insertable = false, updatable = false)
    private Aeropuerto aeropuertoOrigen;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_id", insertable = false, updatable = false)
    private Aeropuerto aeropuertoDestino;

    private Date fechaHoraVuelo;

    private int duracionVuelo;

    @ManyToMany(mappedBy = "vuelos")
    List<Tripulante> tripulantes;

    public Vuelo(String company, Avion avion, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, Date fechaHoraVuelo, int duracionVuelo, List<Tripulante> tripulantes) {
        this.company = company;
        this.avion = avion;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.fechaHoraVuelo = fechaHoraVuelo;
        this.duracionVuelo = duracionVuelo;
        this.tripulantes = tripulantes;
    }
}
