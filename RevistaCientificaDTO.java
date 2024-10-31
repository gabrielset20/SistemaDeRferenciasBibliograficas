package com.example.gestaobibliografica.DTOs;

import com.example.gestaobibliografica.model.Artigo;

import java.util.List;

public class RevistaCientificaDTO {

    private Long id;
    private String ISSN;
    private String nome;

    private List<Artigo> artigos;

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    public RevistaCientificaDTO(Long id, String ISSN, String nome, List<Artigo> artigos) {
        this.id = id;
        this.ISSN = ISSN;
        this.nome = nome;
        this.artigos = artigos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
