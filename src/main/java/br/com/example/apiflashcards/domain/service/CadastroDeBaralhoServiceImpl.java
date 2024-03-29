package br.com.example.apiflashcards.domain.service;

import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoComCartasRequestDTO;
import br.com.example.apiflashcards.domain.model.Baralho;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeBaralhoServicePorta;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeCartaServicePorta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeBaralhoRepositoryPorta;

public class CadastroDeBaralhoServiceImpl implements CadastroDeBaralhoServicePorta {
	private final CadastroDeBaralhoRepositoryPorta cadastroDeBaralhoRepositoryPorta;
	private final CadastroDeCartaServicePorta cadastroDeCartaServicePorta;

	public CadastroDeBaralhoServiceImpl(CadastroDeBaralhoRepositoryPorta cadastroDeBaralhoRepositoryPorta,
			CadastroDeCartaServicePorta cadastroDeCartaServicePorta) {
		this.cadastroDeBaralhoRepositoryPorta = cadastroDeBaralhoRepositoryPorta;
		this.cadastroDeCartaServicePorta = cadastroDeCartaServicePorta;
	}

	@Override
	public String cadastrarBaralhoComCartas(CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO) {
		Baralho baralho = new Baralho(cadastroDeBaralhoDTO);
		Long idBaralho = cadastroDeBaralhoRepositoryPorta.save(baralho).getId();
		return cadastroDeCartaServicePorta.cadastrarCartas(cadastroDeBaralhoDTO.getBaralho().getCartas(), idBaralho);
	}

}
