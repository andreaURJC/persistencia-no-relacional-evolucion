package com.urjc.plains.dtos;

public class AvionesRevisadosDTO {

    String matricula;
    String nombre;
    String apellidos;

    public AvionesRevisadosDTO() { }

    public AvionesRevisadosDTO(String matricula, String nombre, String apellidos) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        return "Avion con matrícula: " + matricula + ". Revisado por el mecánico " + nombre + " " + apellidos + ".";
    }
}
