package repository;

import model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
}
