package com.ap.ap.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class habilidades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHabi;
    private String name;
    private Number stars;

    public habilidades() {

    }

    public habilidades(Long idHabi, String name, Number stars) {
        this.idHabi = idHabi;
        this.name = name;
        this.stars = stars;
    }

    public Long getIdHabi() {
        return idHabi;
    }

    public void setIdHabi(Long idHabi) {
        this.idHabi = idHabi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getStars() {
        return stars;
    }

    public void setStars(Number stars) {
        this.stars = stars;
    }
}
