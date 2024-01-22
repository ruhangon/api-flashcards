package br.com.example.apiflashcards.domain.classes.out;

import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeCartaRepositoryPorta;

public class FakeBuscaDeCartaRepositoryImpl implements BuscaDeCartaRepositoryPorta {

	@Override
	public CartaEntity getById(Long idCarta) {
		return new CartaEntity();
	}

	@Override
	public Integer findFila(Long idCarta) {
		return 1;
	}

}
