package com.urjc.plains.dtos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CiudadesOrigenTripulanteDTO {

    String nombre;
    String apellidos;
    String ciudadOrigen;
    Date fechaVuelo;

    public CiudadesOrigenTripulanteDTO(String nombre, String apellidos, String ciudadOrigen, Date fechaVuelo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudadOrigen = ciudadOrigen;
        this.fechaVuelo = fechaVuelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return "Ciudad: " + ciudadOrigen + ", el día: " + dateFormat.format(fechaVuelo) + ".";
    }
}
