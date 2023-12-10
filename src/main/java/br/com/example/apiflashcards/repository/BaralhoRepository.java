package br.com.example.apiflashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.apiflashcards.model.Baralho;

@Repository
public interface BaralhoRepository extends JpaRepository<Baralho, Long> {

}
