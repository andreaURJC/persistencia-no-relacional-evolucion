package com.urjc.plains.dtos;

public class AvionesMecanicosResponsablesRevisionesDTO {
    String matriculaAvion;
    String nombre;
    String apellidos;

    public AvionesMecanicosResponsablesRevisionesDTO(String matriculaAvion) {
        this.matriculaAvion = matriculaAvion;
    }

    public AvionesMecanicosResponsablesRevisionesDTO(){}

    public String getMatriculaAvion() {
        return matriculaAvion;
    }

    public void setMatriculaAvion(String matriculaAvion) {
        this.matriculaAvion = matriculaAvion;
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
}
