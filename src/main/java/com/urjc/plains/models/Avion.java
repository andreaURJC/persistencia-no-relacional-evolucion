package com.urjc.plains.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Avion {

    @Id
    @GeneratedValue
    private Long id;

    private String fabricante;

    private String modelo;

    private int horasVuelo;

    public Avion(String fabricante, String modelo, int horasVuelo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.horasVuelo = horasVuelo;
    }

    public Avion() {

    }
}
