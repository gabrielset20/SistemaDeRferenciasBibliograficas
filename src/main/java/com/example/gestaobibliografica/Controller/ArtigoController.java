package com.example.gestaobibliografica.Controller;

import jakarta.persistence.EntityNotFoundException;
import com.example.gestaobibliografica.model.Artigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gestaobibliografica.service.ArtigoService;
import java.util.List;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    // Endpoint para listar todos os artigos
    @GetMapping
    public List<Artigo> listarTodos() {
        return artigoService.findAll();
    }

    // Endpoint para criar um novo artigo
    @PostMapping
    public ResponseEntity<Artigo> criar(@RequestBody Artigo artigo) {
        Artigo novoArtigo = artigoService.salvar(artigo);
        return new ResponseEntity<>(novoArtigo, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um artigo existente
    @PutMapping("/{id}")
    public ResponseEntity<Artigo> atualizar(@PathVariable Long id, @RequestBody Artigo artigoAtualizado) {
        try {
            Artigo artigo = artigoService.atualizar(id, artigoAtualizado);
            return new ResponseEntity<>(artigo, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar um artigo pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            artigoService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
