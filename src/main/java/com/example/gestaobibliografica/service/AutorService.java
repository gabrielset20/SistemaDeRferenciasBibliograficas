package com.example.gestaobibliografica.service;

import com.example.gestaobibliografica.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gestaobibliografica.repository.AutorRepository;
import jakarta.persistence.*;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Listar todos os autores
    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    // Criar um novo autor
    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    // Atualizar um autor existente
    public Autor atualizar(Long id, Autor autorAtualizado) {
        // Busca o autor pelo ID
        Autor autorExistente = autorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado com ID: " + id));

        // Atualiza os campos do autor
        autorExistente.setNome(autorAtualizado.getNome());
        autorExistente.setAfiliacao(autorAtualizado.getAfiliacao());
        autorExistente.setArtigos(autorAtualizado.getArtigos());

        // Salva as mudanças no banco de dados
        return autorRepository.save(autorExistente);
    }

    // Excluir um autor pelo ID
    public void deletar(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new EntityNotFoundException("Autor não encontrado com ID: " + id);
        }
        autorRepository.deleteById(id);
    }
}

