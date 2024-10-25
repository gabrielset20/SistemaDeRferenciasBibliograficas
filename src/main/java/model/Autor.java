package model;

import jakarta.persistence.*;
import java.util.List;

import java.util.List;

// A anotação @Entity indica que essa classe é uma entidade JPA.
@Entity
public class Autor {

    // A anotação @Id marca o campo como chave primária
    // @GeneratedValue indica que o valor será gerado automticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String afiliacao;

    // @ManyToMany indica um relacionamento muitos-para-muitos com a entidade Artigo.
    @ManyToMany(mappedBy = "autores")
    private List<Artigo> artigos;

    public Autor(){}

    public Autor(Long id, String nome, String afiliacao, List<Artigo> artigos) {
        this.id = id;
        this.nome = nome;
        this.afiliacao = afiliacao;
        this.artigos = artigos;
    }

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
}