package br.com.example.apiflashcards.adapter.out.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;
import br.com.example.apiflashcards.domain.model.Carta;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeBaralhoRepositoryPorta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeCartaRepositoryPorta;

@Component
public class CadastroDeCartaRepository implements CadastroDeCartaRepositoryPorta {
	private SpringCadastroDeCartaRepository springCadastroDeCartaRepository;
	private BuscaDeBaralhoRepositoryPorta buscaDeBaralhoRepositoryPorta;

	public CadastroDeCartaRepository(SpringCadastroDeCartaRepository springCadastroDeCartaRepository,
			BuscaDeBaralhoRepositoryPorta buscaDeBaralhoRepositoryPorta) {
		this.springCadastroDeCartaRepository = springCadastroDeCartaRepository;
		this.buscaDeBaralhoRepositoryPorta = buscaDeBaralhoRepositoryPorta;
	}

	@Transactional
	@Override
	public Carta save(Carta carta, Long idBaralho) {
		BaralhoEntity baralhoEntity = buscaDeBaralhoRepositoryPorta.getById(idBaralho);
		CartaEntity cartaEntity = new CartaEntity(carta.getFrente(), carta.getTras(), carta.getFila(), baralhoEntity);
		cartaEntity = springCadastroDeCartaRepository.save(cartaEntity);
		carta.setId(cartaEntity.getId());
		return carta;
	}

}
