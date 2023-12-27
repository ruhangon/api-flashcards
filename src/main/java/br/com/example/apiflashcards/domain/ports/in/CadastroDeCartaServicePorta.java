package br.com.example.apiflashcards.domain.ports.in;

import java.util.List;

import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaDTO;

public interface CadastroDeCartaServicePorta {
	void cadastrarCartas(List<TextoCartaDTO> cartas, Long idBaralho);

}
