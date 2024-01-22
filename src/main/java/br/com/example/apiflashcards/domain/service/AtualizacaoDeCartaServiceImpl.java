package br.com.example.apiflashcards.domain.service;

import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.domain.ports.in.AtualizacaoDeCartaServicePorta;
import br.com.example.apiflashcards.domain.ports.out.AtualizacaoDeCartaRepositoryPorta;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeCartaRepositoryPorta;

public class AtualizacaoDeCartaServiceImpl implements AtualizacaoDeCartaServicePorta {
	private final AtualizacaoDeCartaRepositoryPorta atualizacaoDeCartaRepositoryPorta;
	private final BuscaDeCartaRepositoryPorta buscaDeCartaRepositoryPorta;

	public AtualizacaoDeCartaServiceImpl(AtualizacaoDeCartaRepositoryPorta atualizacaoDeCartaRepositoryPorta,
			BuscaDeCartaRepositoryPorta buscaDeCartaRepositoryPorta) {
		this.atualizacaoDeCartaRepositoryPorta = atualizacaoDeCartaRepositoryPorta;
		this.buscaDeCartaRepositoryPorta = buscaDeCartaRepositoryPorta;
	}

	@Override
	public String atualizarFilaDeCarta(Long idCarta, Integer avaliacao) {
		Integer filaDaCartaAtual = buscaDeCartaRepositoryPorta.findFila(idCarta);
		Integer novaFilaDaCartaAtual = avaliacao + filaDaCartaAtual;
		atualizacaoDeCartaRepositoryPorta.updateFila(idCarta, novaFilaDaCartaAtual);
		return HttpStatus.OK.getReasonPhrase();
	}

}
