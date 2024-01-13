package br.com.example.apiflashcards.adapter.out.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.domain.model.Baralho;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeBaralhoRepositoryPorta;

@Component
public class CadastroDeBaralhoRepository implements CadastroDeBaralhoRepositoryPorta {
	private SpringCadastroDeBaralhoRepository springCadastroDeBaralhoRepository;

	public CadastroDeBaralhoRepository(SpringCadastroDeBaralhoRepository springCadastroDeBaralhoRepository) {
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

}
