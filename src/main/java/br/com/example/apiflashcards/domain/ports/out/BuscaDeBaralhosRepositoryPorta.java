package br.com.example.apiflashcards.domain.ports.out;

import java.util.List;

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;

public interface BuscaDeBaralhosRepositoryPorta {
	List<BaralhoEntity> buscarBaralhos();

}
