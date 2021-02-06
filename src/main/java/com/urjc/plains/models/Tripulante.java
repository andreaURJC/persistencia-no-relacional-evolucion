package com.urjc.plains.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Tripulante extends Empleado {

    @Id
    @GeneratedValue
    private Long id;

    private String puesto;

    public Tripulante() {}

    public Tripulante(String nombre, String apellidos, String empresa, int codigoEmpresa, String puesto) {
        super(nombre, apellidos, empresa, codigoEmpresa);
        this.puesto = puesto;
    }

    @ManyToMany
    @JoinTable(
            name = "tripulante_vuelo",
            joinColumns = {@JoinColumn(name = "tripulante_id")},
            inverseJoinColumns = {@JoinColumn(name = "vuelo_id")}
    )
    private List<Vuelo> vuelos;
}
