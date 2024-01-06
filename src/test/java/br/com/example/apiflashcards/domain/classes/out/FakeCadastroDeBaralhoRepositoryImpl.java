package br.com.example.apiflashcards.domain.classes.out;

import br.com.example.apiflashcards.domain.model.Baralho;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeBaralhoRepositoryPorta;

public class FakeCadastroDeBaralhoRepositoryImpl implements CadastroDeBaralhoRepositoryPorta {

	@Override
	public Baralho save(Baralho baralho) {
		return new Baralho();
	}

}
