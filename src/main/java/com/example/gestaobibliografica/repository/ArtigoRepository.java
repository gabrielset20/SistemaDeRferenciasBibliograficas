package com.example.gestaobibliografica.repository;

import com.example.gestaobibliografica.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
}
