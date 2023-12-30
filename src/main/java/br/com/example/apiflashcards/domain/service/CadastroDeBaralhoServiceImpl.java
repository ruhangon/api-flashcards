package br.com.example.apiflashcards.domain.service;

import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoDTO;
import br.com.example.apiflashcards.domain.Baralho;
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
	public String cadastrarBaralho(CadastroDeBaralhoDTO cadastroDeBaralhoDTO) {
		Baralho baralho = new Baralho(cadastroDeBaralhoDTO);
		cadastroDeBaralhoRepositoryPorta.save(baralho);
		cadastroDeCartaServicePorta.cadastrarCartas(cadastroDeBaralhoDTO.baralho().cartas(), baralho.getId());
		return HttpStatus.CREATED.getReasonPhrase();
	}

}