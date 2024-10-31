package com.example.gestaobibliografica.DTOs;

import com.example.gestaobibliografica.model.Autor;
import com.example.gestaobibliografica.model.RevistaCientifica;

import java.util.ArrayList;
import java.util.List;

public class ArtigoDTO {

    private Long id;
    private String titulo;
    private String anoPublicacao;

    private List<Autor> autores = new ArrayList<>();
    private RevistaCientifica revistaCientifica;

    public ArtigoDTO(Long id, String titulo, String anoPublicacao, List<Autor> autores, RevistaCientifica revistaCientifica) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autores = autores;
        this.revistaCientifica = revistaCientifica;
    }

    public RevistaCientifica getRevistaCientifica() {
        return revistaCientifica;
    }

    public void setRevistaCientifica(RevistaCientifica revistaCientifica) {
        this.revistaCientifica = revistaCientifica;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

}

