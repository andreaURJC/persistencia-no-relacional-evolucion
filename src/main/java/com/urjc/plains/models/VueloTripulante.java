package com.urjc.plains.models;

import javax.persistence.*;

@Entity
public class VueloTripulante {

    @EmbeddedId
    private VueloTripulanteId id;

    @ManyToOne
    @MapsId("id")
    private Vuelo vuelo;

    @ManyToOne
    @MapsId("id")
    private Tripulante tripulante;

    public VueloTripulante() {}

    public VueloTripulante(Vuelo vuelo, Tripulante tripulante) {
        this.vuelo = vuelo;
        this.tripulante = tripulante;
        this.id = new VueloTripulanteId(vuelo.getId(), tripulante.getId());
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
}
