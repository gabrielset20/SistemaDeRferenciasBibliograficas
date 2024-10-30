package com.example.gestaobibliografica.service;

import jakarta.persistence.EntityNotFoundException;
import com.example.gestaobibliografica.model.Artigo;
import com.example.gestaobibliografica.model.Autor;
import com.example.gestaobibliografica.model.RevistaCientifica;
import com.example.gestaobibliografica.repository.ArtigoRepository;
import com.example.gestaobibliografica.repository.AutorRepository;
import com.example.gestaobibliografica.repository.RevistaCientificaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private RevistaCientificaRepository revistaRepository;

    // Listar todos os artigos
    public List<Artigo> findAll() {
        return artigoRepository.findAll();
    }

    // Criar um novo artigo
    public Artigo salvar(Artigo artigo) {


        // Buscar os autores e a revista pelo ID antes de salvar o artigo
        List<Autor> autores = artigo.getAutores().stream()
                .map(autor -> autorRepository.findById(autor.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado com ID: " + autor.getId())))
                .collect(Collectors.toList());

        RevistaCientifica revistaCientifica = revistaRepository.findById(artigo.getRevistaCientifica().getId())
                .orElseThrow(() -> new EntityNotFoundException("Revista científica não encontrada com ID: "
                        + artigo.getRevistaCientifica().getId()));

        // Associar autores e revista ao artigo
        artigo.setAutores(autores);
        artigo.setRevistaCientifica(revistaCientifica);

        // Salvar o artigo no repositório
        return artigoRepository.save(artigo);
    }

    // Atualizar um artigo existente
    public Artigo atualizar(Long id, Artigo artigoAtualizado) {
        Artigo artigoExistente = artigoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Artigo não encontrado com ID: " + id));

        // Atualizar os campos de artigo
        artigoExistente.setTitulo(artigoAtualizado.getTitulo());
        artigoExistente.setAnoPublicacao(artigoAtualizado.getAnoPublicacao());

        // Buscar e associar os autores e a revista
        List<Autor> autores = artigoAtualizado.getAutores().stream()
                .map(autor -> autorRepository.findById(autor.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado com ID: " + autor.getId())))
                .collect(Collectors.toList());

        RevistaCientifica revistaCientifica = revistaRepository.findById(artigoAtualizado.getRevistaCientifica().getId())
                .orElseThrow(() -> new EntityNotFoundException("Revista científica não encontrada com ID: "
                        + artigoAtualizado.getRevistaCientifica().getId()));

        // Associar os autores e a revista ao artigo existente
        artigoExistente.setAutores(autores);
        artigoExistente.setRevistaCientifica(revistaCientifica);

        // Salvar o artigo atualizado no banco de dados
        return artigoRepository.save(artigoExistente);
    }

    public void deletar(Long id) {
        if (!artigoRepository.existsById(id)) {
            throw new EntityNotFoundException("Artigo não encontrado com ID: " + id);
        }
        artigoRepository.deleteById(id);
    }
}
