package com.urjc.plains.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class VueloTripulanteId implements Serializable {

    private Long vueloId;
    private Long tripulanteId;

    public VueloTripulanteId() {}

    public VueloTripulanteId(Long vueloId, Long tripulanteId) {
        this.vueloId = vueloId;
        this.tripulanteId = tripulanteId;
    }

    public Long getVueloId() {
        return vueloId;
    }

    public Long getTripulanteId() {
        return tripulanteId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }

    public void setTripulanteId(Long tripulanteId) {
        this.tripulanteId = tripulanteId;
    }
}
