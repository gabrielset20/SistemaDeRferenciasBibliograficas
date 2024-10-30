package com.example.gestaobibliografica.Controller;

import jakarta.persistence.EntityNotFoundException;
import com.example.gestaobibliografica.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gestaobibliografica.service.AutorService;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Endpoint para listar todos os autores
    @GetMapping
    public List<Autor> listarTodos() {
        return autorService.listarTodos();
    }

    // Endpoint para criar um novo autor
    @PostMapping
    public ResponseEntity<Autor> criar(@RequestBody Autor autor) {
        Autor novoAutor = autorService.salvar(autor);
        return new ResponseEntity<>(novoAutor, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um autor existente
    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizar(@PathVariable Long id, @RequestBody Autor autorAtualizado) {
        try {
            Autor autor = autorService.atualizar(id, autorAtualizado);
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar um autor pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            autorService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

