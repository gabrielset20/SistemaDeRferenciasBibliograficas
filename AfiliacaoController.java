package com.example.gestaobibliografica.Controller;



import com.example.gestaobibliografica.model.Afiliacao;
import com.example.gestaobibliografica.model.Artigo;
import com.example.gestaobibliografica.service.AfiliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.AnnotationFormatError;
import java.util.List;

@RestController
@RequestMapping("/afiliacao")
public class AfiliacaoController {

    @Autowired
    private AfiliacaoService afiliacaoService;

    @PostMapping
    public ResponseEntity<Afiliacao> create(@RequestBody Afiliacao afiliacao) {
        Afiliacao novaAfiliacao = afiliacaoService.create(afiliacao);
        return new ResponseEntity<>(novaAfiliacao, HttpStatus.CREATED);
    }

    // Endpoint para listar todos os artigos
    @GetMapping
    public List<Afiliacao> listarTodos() {
        return afiliacaoService.listarTodos();
    }
}
