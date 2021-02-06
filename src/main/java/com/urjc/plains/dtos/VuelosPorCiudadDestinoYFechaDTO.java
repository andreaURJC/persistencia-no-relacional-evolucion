package com.urjc.plains.dtos;

import java.util.Date;

public class VuelosPorCiudadDestinoYFechaDTO {

    private Long codigoVuelo;
    private String compania;

    private String iataOrigen;
    private String iataDestino;

    private Date fechaHora;
    private Double duracion;

    public VuelosPorCiudadDestinoYFechaDTO(Long codigoVuelo, String compania, String iataOrigen, String iataDestino, Date fechaHora, Double duracion) {
        this.codigoVuelo = codigoVuelo;
        this.compania = compania;
        this.iataOrigen = iataOrigen;
        this.iataDestino = iataDestino;
        this.fechaHora = fechaHora;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Código del vuelo: " + codigoVuelo +
                " | Companía: " + compania +
                " | IATA aeropuerto de origen: " + iataOrigen +
                " | IATA aeropuerto de destino: " + iataDestino +
                " | Fecha y hora de salida: " + fechaHora +
                " | Duración del vuelo: " + duracion + " h";
    }
}
