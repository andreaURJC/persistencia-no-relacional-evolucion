package com.urjc.plains.models;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoEmpleado;

    private String nombre;

    private String apellidos;

    Empleado(){}

    Empleado(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Long getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Long id) {
        this.codigoEmpleado = id;
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
