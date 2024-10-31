package com.example.gestaobibliografica.DTOs;

import com.example.gestaobibliografica.model.Autor;
import java.util.ArrayList;
import java.util.List;

public class AfiliacaoDTO {

    private Long id;
    private String name;
    private String referencia;
    private String sigla;

    private List<Autor> autores = new ArrayList<>();

    public AfiliacaoDTO(Long id, String name, String referencia, String sigla, List<Autor> autores) {
        this.id = id;
        this.name = name;
        this.referencia = referencia;
        this.sigla = sigla;
        this.autores = autores;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
