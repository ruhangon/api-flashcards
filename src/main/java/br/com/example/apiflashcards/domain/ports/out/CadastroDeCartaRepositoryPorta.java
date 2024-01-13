package br.com.example.apiflashcards.domain.ports.out;

import br.com.example.apiflashcards.domain.model.Carta;

public interface CadastroDeCartaRepositoryPorta {
	Carta save(Carta carta, Long idBaralho);

}
