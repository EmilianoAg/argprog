package com.ap.ap.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCurs;
    private String name;
    private Number anio;

    public cursos() {
    }

    public cursos(Long idCurs, String name, Number anio) {
        this.idCurs = idCurs;
        this.name = name;
        this.anio = anio;
    }

    public Long getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(Long idCurs) {
        this.idCurs = idCurs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getAnio() {
        return anio;
    }

    public void setAnio(Number anio) {
        this.anio = anio;
    }
}
