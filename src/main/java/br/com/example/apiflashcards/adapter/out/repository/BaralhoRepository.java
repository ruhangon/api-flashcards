package br.com.example.apiflashcards.adapter.out.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.domain.Baralho;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeBaralhoRepositoryPorta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeBaralhoRepositoryPorta;

@Component
public class BaralhoRepository implements CadastroDeBaralhoRepositoryPorta, BuscaDeBaralhoRepositoryPorta {
	private SpringCadastroDeBaralhoRepository springCadastroDeBaralhoRepository;

	public BaralhoRepository(SpringCadastroDeBaralhoRepository springCadastroDeBaralhoRepository) {
		this.springCadastroDeBaralhoRepository = springCadastroDeBaralhoRepository;
	}

	@Transactional
	@Override
	public Baralho save(Baralho baralho) {
		BaralhoEntity baralhoEntity = new BaralhoEntity(baralho.getNome());
		baralhoEntity = springCadastroDeBaralhoRepository.save(baralhoEntity);
		baralho.setId(baralhoEntity.getId());
		return baralho;
	}

	@Override
	public BaralhoEntity getById(Long id) {
		return springCadastroDeBaralhoRepository.getById(id);
	}

}
