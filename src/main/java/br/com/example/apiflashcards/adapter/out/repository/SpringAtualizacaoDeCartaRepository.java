package br.com.example.apiflashcards.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;

@Repository
public interface SpringAtualizacaoDeCartaRepository extends JpaRepository<CartaEntity, Long> {
}
