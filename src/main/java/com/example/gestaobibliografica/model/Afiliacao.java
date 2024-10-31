package com.example.gestaobibliografica.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Afiliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String sigla;

    @Column(nullable = false, unique = true)
    private String referencia;

    @OneToMany(mappedBy = "afiliacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Autor> autores = new ArrayList<>();

    public Afiliacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Afiliacao(Long id, String name, String sigla, String referencia, List<Autor> autores) {
        this.id = id;
        this.name = name;
        this.sigla = sigla;
        this.referencia = referencia;
        this.autores = autores;
    }
}
