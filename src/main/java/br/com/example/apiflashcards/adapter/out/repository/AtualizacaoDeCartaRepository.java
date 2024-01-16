package br.com.example.apiflashcards.adapter.out.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;
import br.com.example.apiflashcards.domain.ports.out.AtualizacaoDeCartaRepositoryPorta;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeCartaRepositoryPorta;

@Component
public class AtualizacaoDeCartaRepository implements AtualizacaoDeCartaRepositoryPorta {
	private SpringAtualizacaoDeCartaRepository springAtualizacaoDeCartaRepository;
	private BuscaDeCartaRepositoryPorta buscaDeCartaRepositoryPorta;

	public AtualizacaoDeCartaRepository(SpringAtualizacaoDeCartaRepository springAtualizacaoDeCartaRepository,
			BuscaDeCartaRepositoryPorta buscaDeCartaRepositoryPorta) {
		this.springAtualizacaoDeCartaRepository = springAtualizacaoDeCartaRepository;
		this.buscaDeCartaRepositoryPorta = buscaDeCartaRepositoryPorta;
	}

	@Transactional
	@Override
	public void updateFila(Long id, Integer novaFila) {
		CartaEntity cartaEntity = buscaDeCartaRepositoryPorta.getById(id);
		cartaEntity.setFila(novaFila);
		springAtualizacaoDeCartaRepository.save(cartaEntity);
	}

}
