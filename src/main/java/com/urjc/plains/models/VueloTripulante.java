package com.urjc.plains.models;

import javax.persistence.*;

@Entity
public class VueloTripulante {

    @EmbeddedId
    private VueloTripulanteId id;

    @ManyToOne
    @MapsId("vueloId")
    private Vuelo vuelo;

    @ManyToOne
    @MapsId("tripulanteId")
    private Tripulante tripulante;

    public VueloTripulante() {}

    public VueloTripulante(Vuelo vuelo, Tripulante tripulante) {
        this.vuelo = vuelo;
        this.tripulante = tripulante;
        this.id = new VueloTripulanteId(vuelo.getCodigoVuelo(), tripulante.getCodigoEmpleado());
    }

    public VueloTripulanteId getId() {
        return id;
    }

    public void setId(VueloTripulanteId id) {
        this.id = id;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Tripulante getTripulante() {
        return tripulante;
    }

    public void setTripulante(Tripulante tripulante) {
        this.tripulante = tripulante;
    }

    @Override
    public String toString() {
        
        return "VueloTripulante[ tripulante: " + tripulante.getNombre() + " " + tripulante.getApellidos() +
        " | vuelo: " + vuelo.getCodigoVuelo() + " ]";
    }
}
