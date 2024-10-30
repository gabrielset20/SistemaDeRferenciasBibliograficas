package com.example.gestaobibliografica.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//Indicar classe como entidade JPA.
@Entity
public class Artigo {

    // Declarar chave primária com GeneratedValue para gerar automaticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int anoPublicacao;

    // Relacionamento muitos-para-muitos com a entidade Autor.
    @ManyToMany
    @JoinTable(
            name = "artigo_autor",
            joinColumns = @JoinColumn(name = "artigo_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

    // Relacionamento muitos-para-um com RevistaCientifica.
    @ManyToOne
    @JoinColumn(name = "revista_id")
    private RevistaCientifica revistaCientifica;

    public Artigo() {}

    public Artigo(RevistaCientifica revistaCientifica, List<Autor> autores, int anoPublicacao, String titulo, Long id) {
        this.revistaCientifica = revistaCientifica;
        this.autores = autores;
        this.anoPublicacao = anoPublicacao;
        this.titulo = titulo;
        this.id = id;
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

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public RevistaCientifica getRevistaCientifica() {
        return revistaCientifica;
    }

    public void setRevistaCientifica(RevistaCientifica revistaCientifica) {
        this.revistaCientifica = revistaCientifica;
    }
}
