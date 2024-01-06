package br.com.example.apiflashcards.domain.classes.out;

import java.util.ArrayList;
import java.util.List;

import br.com.example.apiflashcards.domain.model.Carta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeCartaRepositoryPorta;

public class FakeCadastroDeCartaRepositoryImpl implements CadastroDeCartaRepositoryPorta {
	private List<Carta> cartas = new ArrayList<>();

	@Override
	public Carta save(Carta carta, Long idBaralho) {
		carta.setId(1L);
		cartas.add(carta);
		return carta;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

}
