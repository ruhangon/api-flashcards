package br.com.example.apiflashcards.adapter.out.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeBaralhosRepositoryPorta;

@Component
public class BuscaDeBaralhosRepository implements BuscaDeBaralhosRepositoryPorta {
	private SpringBuscaDeBaralhoRepository springBuscaDeBaralhoRepository;

	public BuscaDeBaralhosRepository(SpringBuscaDeBaralhoRepository springBuscaDeBaralhoRepository) {
		this.springBuscaDeBaralhoRepository = springBuscaDeBaralhoRepository;
	}

	@Override
	public List<BaralhoEntity> buscarBaralhos() {
		return springBuscaDeBaralhoRepository.findAll();
	}

}
