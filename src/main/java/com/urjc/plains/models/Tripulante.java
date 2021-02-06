package com.urjc.plains.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tripulante extends Empleado {

    private String puesto;

    private String compania;

    @OneToMany(mappedBy = "tripulante", cascade = CascadeType.ALL)
    private List<VueloTripulante> vuelos;

    public Tripulante() {}

    public Tripulante(String nombre, String apellidos, String compania, String puesto) {
        super(nombre, apellidos);
        this.compania = compania;
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public List<VueloTripulante> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<VueloTripulante> vuelos) {
        this.vuelos = vuelos;
    }
}
