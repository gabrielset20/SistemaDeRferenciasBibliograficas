package com.example.gestaobibliografica.service;

import com.example.gestaobibliografica.model.Afiliacao;
import com.example.gestaobibliografica.repository.AfiliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AfiliacaoService {

    @Autowired
    private AfiliacaoRepository afiliacaoRepository;

    // Listar todos os artigos
    public List<Afiliacao> listarTodos() {
        return afiliacaoRepository.findAll();
    }

    //Criar um novo artigo
    public Afiliacao create(Afiliacao afiliacao) {
        return afiliacaoRepository.save(afiliacao);
    }
}
