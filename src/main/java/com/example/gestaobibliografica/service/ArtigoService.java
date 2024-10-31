package com.example.gestaobibliografica.service;

import com.example.gestaobibliografica.model.Artigo;
import com.example.gestaobibliografica.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.*;
import java.util.List;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    // Listar todos os artigos
    public List<Artigo> listarTodos() {
        return artigoRepository.findAll();
    }

    // Criar um novo artigo
    public Artigo salvar(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    // Atualizar um artigo existente
    public Artigo atualizar(Long id, Artigo artigoAtualizado) {
        Artigo artigoExistente = artigoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Artigo não encontrado com ID: " + id));

        artigoExistente.setTitulo(artigoAtualizado.getTitulo());
        artigoExistente.setAnoPublicacao(artigoAtualizado.getAnoPublicacao());
        artigoExistente.setAutores(artigoAtualizado.getAutores());
        artigoExistente.setRevistaCientifica(artigoAtualizado.getRevistaCientifica());

        return artigoRepository.save(artigoExistente);
    }

    // Excluir um artigo pelo ID
    public void deletar(Long id) {
        if (!artigoRepository.existsById(id)) {
            throw new EntityNotFoundException("Artigo não encontrado com ID: " + id);
        }
        artigoRepository.deleteById(id);
    }
}
