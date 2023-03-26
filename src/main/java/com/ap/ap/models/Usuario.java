package com.ap.ap.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)

    private Long id;
    private String name;
    private String titulo;
    private String ciudad;
    private String pais;

    public Usuario() {
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEsc")
    private List<Escuela> escuelaList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idCurs")
    private List<cursos> cursosList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idHabi")
    private List<habilidades> habilidadesList;


    public Usuario(Long id, String name, String titulo, String ciudad, String pais) {
        this.id = id;
        this.name = name;
        this.titulo = titulo;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Long getIdUser() {
        return id;
    }

    public void setIdUser(Long idUser) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
