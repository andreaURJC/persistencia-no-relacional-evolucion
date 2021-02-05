package com.urjc.plains.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aeropuerto {

    @Id
    @GeneratedValue
    private Long id;
}
