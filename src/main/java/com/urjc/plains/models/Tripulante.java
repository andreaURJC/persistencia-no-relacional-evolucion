package com.urjc.plains.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tripulante extends Empleado {

    @Id
    @GeneratedValue
    private Long id;

    private String puesto;

    @OneToMany(mappedBy = "tripulante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VueloTripulante> vuelos;

    public Tripulante() {}

    public Tripulante(String nombre, String apellidos, String empresa, int codigoEmpresa, String puesto) {
        super(nombre, apellidos, empresa, codigoEmpresa);
        this.puesto = puesto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public List<VueloTripulante> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<VueloTripulante> vuelos) {
        this.vuelos = vuelos;
    }
}
