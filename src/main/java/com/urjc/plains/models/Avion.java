package com.urjc.plains.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Avion {

    @Id
    @GeneratedValue
    private Long id;
}
