package com.urjc.plains.models.mongo;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Provincia {

    @Id
    private String id;
    private String Nombre;
    private String CA;
    private Integer Superficie;
    private List<Dato> Datos;

    public Provincia() {
    }

    public Provincia(String nombre, String CA, Integer superficie, List<Dato> datos) {
        this.Nombre = nombre;
        this.CA = CA;
        this.Superficie = superficie;
        this.Datos = datos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getCA() {
        return CA;
    }

    public void setCA(String CA) {
        this.CA = CA;
    }

    public Integer getSuperficie() {
        return Superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.Superficie = superficie;
    }

    public List<Dato> getDatos() {
        return Datos;
    }

    public void setDatos(List<Dato> datos) {
        this.Datos = datos;
    }
}
