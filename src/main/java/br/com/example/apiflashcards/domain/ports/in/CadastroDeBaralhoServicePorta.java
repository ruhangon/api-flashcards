package br.com.example.apiflashcards.domain.ports.in;

import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoDTO;

public interface CadastroDeBaralhoServicePorta {
	String cadastrarBaralho(CadastroDeBaralhoDTO cadastroDeBaralhoDTO);

}
