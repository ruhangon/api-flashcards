package br.com.example.apiflashcards.domain.classes.out;

import br.com.example.apiflashcards.domain.model.Carta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeCartaRepositoryPorta;

public class FakeCadastroDeCartaRepositoryImpl implements CadastroDeCartaRepositoryPorta {

	@Override
	public void save(Carta carta, Long idBaralho) {
	}

}
