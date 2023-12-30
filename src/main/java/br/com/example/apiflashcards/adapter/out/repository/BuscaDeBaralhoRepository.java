package br.com.example.apiflashcards.adapter.out.repository;

import org.springframework.stereotype.Component;

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeBaralhoRepositoryPorta;

@Component
public class BuscaDeBaralhoRepository implements BuscaDeBaralhoRepositoryPorta {
	private SpringBuscaDeBaralhoRepository springBuscaDeBaralhoRepository;

	public BuscaDeBaralhoRepository(SpringBuscaDeBaralhoRepository springBuscaDeBaralhoRepository) {
		this.springBuscaDeBaralhoRepository = springBuscaDeBaralhoRepository;
	}

	@Override
	public BaralhoEntity getById(Long id) {
		return springBuscaDeBaralhoRepository.getById(id);
	}

}
