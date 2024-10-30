package com.example.gestaobibliografica.DTOs;

import com.example.gestaobibliografica.model.Artigo;

import java.util.List;
// Os DTOs são usados para transferir dados entre as camadas da aplicação.
// Eles são especialmente úteis quando não queremos expor diretamente as
// entidades para a camada de apresentação.

public class AutorDTO {

    private Long id;
    private String nome;
    private String afiliacao;

    private List<Artigo> artigos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    public AutorDTO(Long id, String nome, String afiliacao, List<Artigo> artigos) {
        this.id = id;
        this.nome = nome;
        this.afiliacao = afiliacao;
        this.artigos = artigos;
    }
}
