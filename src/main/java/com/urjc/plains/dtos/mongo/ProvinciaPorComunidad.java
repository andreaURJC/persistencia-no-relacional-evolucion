package com.urjc.plains.dtos.mongo;

public class ProvinciaPorComunidad {

    String _id;
    Integer numeroProvincias;

    public ProvinciaPorComunidad() {
    }

    public ProvinciaPorComunidad(String _id, Integer numeroProvincias) {
        this._id = _id;
        this.numeroProvincias = numeroProvincias;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getNumeroProvincias() {
        return numeroProvincias;
    }

    public void setNumeroProvincias(Integer numeroProvincias) {
        this.numeroProvincias = numeroProvincias;
    }

    @Override
    public String toString() {
        return "Comunidad: " + _id + " | Número de provincias: " + numeroProvincias;
    }
}
