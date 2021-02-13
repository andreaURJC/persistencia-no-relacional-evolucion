package com.urjc.plains.models.mongo;

public class Dato {

    private Integer Anyo;
    private Integer Valor;

    public Dato() {
    }

    public Dato(Integer anyo, Integer valor) {
        this.Anyo = anyo;
        this.Valor = valor;
    }

    public Integer getAnyo() {
        return Anyo;
    }

    public void setAnyo(Integer anyo) {
        this.Anyo = anyo;
    }

    public Integer getValor() {
        return Valor;
    }

    public void setValor(Integer valor) {
        this.Valor = valor;
    }

    @Override
    public String toString() {
        return "Anyo: " + this.Anyo + " | Población: " + Valor;
    }
}
