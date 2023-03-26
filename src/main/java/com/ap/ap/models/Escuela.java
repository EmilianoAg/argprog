package com.ap.ap.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Escuela {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEsc;
    private String name;
    private String tituloEsc;
    private Integer anioInicio;
    private Integer anioFinal;

    public Escuela() {
    }

    public Escuela(Long idEsc, String name, String tituloEsc, Integer anioInicio, Integer anioFinal) {
        this.idEsc = idEsc;
        this.name = name;
        this.tituloEsc = tituloEsc;
        this.anioInicio = anioInicio;
        this.anioFinal = anioFinal;
    }

    public Long getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(Long idEsc) {
        this.idEsc = idEsc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTituloEsc() {
        return tituloEsc;
    }

    public void setTituloEsc(String tituloEsc) {
        this.tituloEsc = tituloEsc;
    }

    public Integer getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(Integer anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Integer getAnioFinal() {
        return anioFinal;
    }

    public void setAnioFinal(Integer anioFinal) {
        this.anioFinal = anioFinal;
    }
}
