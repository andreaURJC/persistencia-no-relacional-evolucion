package com.urjc.plains.dtos;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ResumenVuelosTripulantesDTO {

    String nombre;
    String apellido;
    Long numeroVuelos;
    Double sumaHoras;

    public ResumenVuelosTripulantesDTO(String nombre, String apellido, Long numeroVuelos, Double sumaHoras) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroVuelos = numeroVuelos;
        this.sumaHoras = sumaHoras;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        return "Tripulante: " + nombre + " " + apellido
                + " ha realizado un total de " + numeroVuelos + " vuelos"
                + ", con una suma total de " + decimalFormat.format(sumaHoras) + " horas.";
    }
}
