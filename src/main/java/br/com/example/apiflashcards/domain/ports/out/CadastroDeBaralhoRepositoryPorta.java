package br.com.example.apiflashcards.domain.ports.out;

import br.com.example.apiflashcards.domain.Baralho;

public interface CadastroDeBaralhoRepositoryPorta {
	Baralho save(Baralho baralho);

}
