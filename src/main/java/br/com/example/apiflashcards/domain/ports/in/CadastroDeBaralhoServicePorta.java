package br.com.example.apiflashcards.domain.ports.in;

import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoComCartasRequestDTO;

public interface CadastroDeBaralhoServicePorta {
	String cadastrarBaralhoComCartas(CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO);

}
