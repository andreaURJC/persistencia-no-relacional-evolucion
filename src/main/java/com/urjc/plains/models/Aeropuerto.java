package com.urjc.plains.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Aeropuerto {

    @Id
    @Column(length = 3)
    private String iata;

    private String nombre;

    private String ciudad;

    private String pais;

    @OneToMany(mappedBy = "aeropuerto")
    private List<Revision> revisiones;

    @OneToMany(mappedBy = "aeropuertoOrigen")
    private List<Vuelo> vuelosSalida;

    @OneToMany(mappedBy = "aeropuertoDestino")
    private List<Vuelo> vuelosLlegada;

    public Aeropuerto() {}

    public Aeropuerto(String iata, String nombre, String ciudad, String pais) {
        this.iata = iata;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    public List<Vuelo> getVuelosSalida() {
        return vuelosSalida;
    }

    public void setVuelosSalida(List<Vuelo> vuelosSalida) {
        this.vuelosSalida = vuelosSalida;
    }

    public List<Vuelo> getVuelosLlegada() {
        return vuelosLlegada;
    }

    public void setVuelosLlegada(List<Vuelo> vuelosLlegada) {
        this.vuelosLlegada = vuelosLlegada;
    }
}
