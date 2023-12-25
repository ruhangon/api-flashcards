package br.com.example.apiflashcards.adaptador.saida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.apiflashcards.adaptador.saida.entity.CartaEntity;

@Repository
public interface SpringCadastroDeCartaRepository extends JpaRepository<CartaEntity, Long> {

}
