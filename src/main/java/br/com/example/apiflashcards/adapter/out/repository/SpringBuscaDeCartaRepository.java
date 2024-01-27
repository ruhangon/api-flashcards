package br.com.example.apiflashcards.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;

@Repository
public interface SpringBuscaDeCartaRepository extends JpaRepository<CartaEntity, Long> {
	@Query("SELECT COUNT(*) FROM carta WHERE baralho.id = :baralho")
	Long countCartasBaralho(@Param("baralho") Long baralho);

}
