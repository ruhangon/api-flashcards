package br.com.example.apiflashcards.adapter.out.repository;

import org.springframework.stereotype.Component;

import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeCartaRepositoryPorta;

@Component
public class BuscaDeCartaRepository implements BuscaDeCartaRepositoryPorta {
	private SpringBuscaDeCartaRepository springBuscaDeCartaRepository;

	public BuscaDeCartaRepository(SpringBuscaDeCartaRepository springBuscaDeCartaRepository) {
		this.springBuscaDeCartaRepository = springBuscaDeCartaRepository;
	}

	@Override
	public CartaEntity getById(Long id) {
		return springBuscaDeCartaRepository.getById(id);
	}

	@Override
	public Integer findFila(Long id) {
		return springBuscaDeCartaRepository.getById(id).getFila();
	}

}
