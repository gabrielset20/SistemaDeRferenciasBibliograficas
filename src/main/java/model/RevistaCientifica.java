package model;

import jakarta.persistence.*;
import java.util.List;

//Indica como uma entidade JPA.
@Entity
public class RevistaCientifica {

    //Faz com que seja chave primária e gere automaticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // a anotação unique de @Column garante que ISSN será um valor único.
    @Column(unique = true)
    private String ISSN;

    private String nome;

    //Relacionamento um-para-muitos com Artigo.
    @OneToMany(mappedBy = "revistaCienifica")
    private List<Artigo> artigos;

    public RevistaCientifica() {}

    public RevistaCientifica(Long id, String ISSN, String nome, List<Artigo> artigos) {
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

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }
}
