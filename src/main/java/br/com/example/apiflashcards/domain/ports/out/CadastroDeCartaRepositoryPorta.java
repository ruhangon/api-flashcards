package br.com.example.apiflashcards.domain.ports.out;

import br.com.example.apiflashcards.domain.Carta;

public interface CadastroDeCartaRepositoryPorta {
	void save(Carta carta, Long idBaralho);

}
