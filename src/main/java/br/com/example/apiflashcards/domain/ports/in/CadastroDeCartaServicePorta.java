package br.com.example.apiflashcards.domain.ports.in;

import java.util.List;

import br.com.example.apiflashcards.adapter.in.model.request.TextoCartaRequestDTO;

public interface CadastroDeCartaServicePorta {
	void cadastrarCartas(List<TextoCartaRequestDTO> cartas, Long idBaralho);

}
