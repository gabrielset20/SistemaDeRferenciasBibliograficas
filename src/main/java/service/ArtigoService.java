package service;

import jakarta.persistence.EntityNotFoundException;
import model.Artigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ArtigoRepository;

import java.util.List;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    // Listar todos os artigos.
    public List<Artigo> findAll() {
        return artigoRepository.findAll();
    }

    // Criar um novo artigo.
    public Artigo salvar(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    // Atualizar um artigo existete.
    public Artigo atualizar(Long id, Artigo artigoAtualizado) {
        Artigo artigoExistente = artigoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Artigo não encontrado com ID: " + id));

        // Atualizar os campos de artigo
        artigoExistente.setTitulo(artigoAtualizado.getTitulo());
        artigoExistente.setAnoPublicacao(artigoAtualizado.getAnoPublicacao());
        artigoExistente.setAutores(artigoAtualizado.getAutores());
        artigoExistente.setRevistaCientifica(artigoAtualizado.getRevistaCientifica());

        //salvar no banco de dados
        return artigoRepository.save(artigoExistente);
    }

    public void deletar(Long id) {
        if (!artigoRepository.existsById(id)) {
            throw new EntityNotFoundException("Artigo não encontrado com ID: " + id);
        }
        artigoRepository.deleteById(id);
    }

}
