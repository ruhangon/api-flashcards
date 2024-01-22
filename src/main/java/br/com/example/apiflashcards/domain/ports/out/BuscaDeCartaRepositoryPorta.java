package br.com.example.apiflashcards.domain.ports.out;

import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;

public interface BuscaDeCartaRepositoryPorta {
	CartaEntity getById(Long idCarta);

	Integer findFila(Long idCarta);

}
