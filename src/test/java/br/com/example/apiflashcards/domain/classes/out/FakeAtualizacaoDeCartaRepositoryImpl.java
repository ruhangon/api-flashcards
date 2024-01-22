package br.com.example.apiflashcards.domain.classes.out;

import br.com.example.apiflashcards.domain.ports.out.AtualizacaoDeCartaRepositoryPorta;

public class FakeAtualizacaoDeCartaRepositoryImpl implements AtualizacaoDeCartaRepositoryPorta {
	private int novaFilaDaCartaAtual;

	@Override
	public void updateFila(Long idCarta, Integer novaFilaDaCartaAtual) {
		this.novaFilaDaCartaAtual = novaFilaDaCartaAtual;
	}

	public int getNovaFilaDaCartaAtual() {
		return novaFilaDaCartaAtual;
	}

}
