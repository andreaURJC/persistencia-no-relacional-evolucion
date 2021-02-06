package com.urjc.plains.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Mecanico extends Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int anoIncorporacion;

    private String formacion;

    public Mecanico() {}

    public Mecanico(String nombre, String apellidos, String empresa, int codigoEmpresa, int anoIncorporacion, String formacion) {
        super(nombre, apellidos, empresa, codigoEmpresa);
        this.anoIncorporacion = anoIncorporacion;
        this.formacion = formacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAnoIncorporacion() {
        return anoIncorporacion;
    }

    public void setAnoIncorporacion(int anoIncorporacion) {
        this.anoIncorporacion = anoIncorporacion;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }
}
