package br.com.example.apiflashcards.dominio.portas.saida;

import br.com.example.apiflashcards.adaptador.saida.entity.BaralhoEntity;

public interface BuscaDeBaralhoRepositoryPorta {
	BaralhoEntity getById(Long id);

}
