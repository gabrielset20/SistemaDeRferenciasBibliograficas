package com.example.gestaobibliografica.service;

import jakarta.persistence.EntityNotFoundException;
import com.example.gestaobibliografica.model.RevistaCientifica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gestaobibliografica.repository.RevistaCientificaRepository;

import java.util.List;

@Service
public class RevistaCientificaService {

    @Autowired
    private RevistaCientificaRepository revistaCientificaRepository;

    // Listar todas as revistas.
    public List<RevistaCientifica> findAll() {
        return revistaCientificaRepository.findAll();
    }

    // Criar uma nova revista.
    public RevistaCientifica salvar(RevistaCientifica revistaCientifica) {
        return revistaCientificaRepository.save(revistaCientifica);
    }

    // Atualizar revista existente.
    public RevistaCientifica atualizar(Long id, RevistaCientifica revistaCientificaAtt) {
        RevistaCientifica revistaExistente = revistaCientificaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Revista Cientifica não encontrada com ID: " + id));

        // Atualização de campos
        revistaExistente.setNome(revistaCientificaAtt.getNome());
        revistaExistente.setISSN(revistaCientificaAtt.getISSN());
        revistaExistente.setArtigos(revistaCientificaAtt.getArtigos());

        // salvar
        return revistaCientificaRepository.save(revistaExistente);
    }
    public void deletar(Long id) {
        if (!revistaCientificaRepository.existsById(id)) {
            throw new EntityNotFoundException("Revista não encontrada com ID: " + id);
        }
        revistaCientificaRepository.deleteById(id);
    }
}
