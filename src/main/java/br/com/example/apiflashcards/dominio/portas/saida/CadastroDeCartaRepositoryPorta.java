package br.com.example.apiflashcards.dominio.portas.saida;

import br.com.example.apiflashcards.dominio.Carta;

public interface CadastroDeCartaRepositoryPorta {
	void save(Carta carta, Long idBaralho);

}
