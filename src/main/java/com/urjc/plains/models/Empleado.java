package com.urjc.plains.models;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Empleado {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String apellidos;

    private String empresa;

    private int codigoEmpresa;

    Empleado(){}

    Empleado(String nombre, String apellidos, String empresa, int codigoEmpresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.empresa = empresa;
        this.codigoEmpresa = codigoEmpresa;
    }
}
