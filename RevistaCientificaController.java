package com.example.gestaobibliografica.Controller;

import jakarta.persistence.EntityNotFoundException;
import com.example.gestaobibliografica.model.RevistaCientifica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gestaobibliografica.service.RevistaCientificaService;

import java.util.List;

@RestController
@RequestMapping("/revistas")
public class RevistaCientificaController {

    @Autowired
    private RevistaCientificaService revistaCientificaService;

    // Endpoint para listar todas as revistas científicas
    @GetMapping
    public List<RevistaCientifica> listarTodos() {
        return revistaCientificaService.findAll();
    }

    // Endpoint para criar uma nova revista científica
    @PostMapping
    public ResponseEntity<RevistaCientifica> criar(@RequestBody RevistaCientifica revistaCientifica) {
        RevistaCientifica novaRevista = revistaCientificaService.salvar(revistaCientifica);
        return new ResponseEntity<>(novaRevista, HttpStatus.CREATED);
    }

    // Endpoint para atualizar uma revista científica existente
    @PutMapping("/{id}")
    public ResponseEntity<RevistaCientifica> atualizar(@PathVariable Long id, @RequestBody RevistaCientifica revistaAtualizada) {
        try {
            RevistaCientifica revista = revistaCientificaService.atualizar(id, revistaAtualizada);
            return new ResponseEntity<>(revista, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar uma revista científica pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            revistaCientificaService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

