package br.com.example.apiflashcards.domain.ports.out;

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;

public interface BuscaDeBaralhoRepositoryPorta {
	BaralhoEntity getById(Long id);

}
