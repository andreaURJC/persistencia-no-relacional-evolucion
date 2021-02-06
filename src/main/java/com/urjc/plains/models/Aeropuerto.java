package com.urjc.plains.models;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {

    @Id
    private int id;          // ?? no se si esta bien clave primaria IATA (?)

    private String nombre;

    private String ciudad;

    private String pais;

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Aeropuerto() {
    }
}
