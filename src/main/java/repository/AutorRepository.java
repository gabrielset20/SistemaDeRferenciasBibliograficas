package repository;

import model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

// Para acessar os dados no banco de forma eficiente, usaremos interfaces que herdam
// de JpaRepository, facilitando as operações CRUD.
// Interface AutorRepository extende JpaRepository para fornecer métodos CRUD prontos.
public interface AutorRepository extends JpaRepository<Autor, Long> {
}

