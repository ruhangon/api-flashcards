package br.com.example.apiflashcards.domain.ports.in;

import br.com.example.apiflashcards.adapter.in.model.request.CadastroDeBaralhoRequestDTO;

public interface CadastroDeBaralhoServicePorta {
	String cadastrarBaralho(CadastroDeBaralhoRequestDTO cadastroDeBaralhoDTO);

}
