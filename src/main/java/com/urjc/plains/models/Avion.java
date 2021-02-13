package com.urjc.plains.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Avion {

    @Id
    private String matricula;

    private String fabricante;

    private String modelo;

    private Integer horasVuelo;

    @OneToMany(mappedBy = "avion")
    List<Revision> revisiones;

    @OneToMany(mappedBy = "avion")
    private List<Vuelo> vuelos;

    private String revisionesJson;

    public Avion() {}

    public Avion(String matricula, String fabricante, String modelo, Integer horasVuelo) {
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.horasVuelo = horasVuelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(Integer horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public String getRevisionesJson() {
        return revisionesJson;
    }

    public void setRevisionesJson(String revisionesJson) {
        this.revisionesJson = revisionesJson;
    }

    @Override
    public String toString() {

        return "Avion[ matricula: " + matricula +
                " | fabricante: " + fabricante +
                " | modelo: " + modelo +
                " | horasVuelo: " + horasVuelo + " ]";
    }

    
}
