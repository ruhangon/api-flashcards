package br.com.example.apiflashcards.domain.ports.in;

import java.util.List;

import br.com.example.apiflashcards.adapter.in.model.dto.InformacaoParaCadastroDeCartaRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaRequestDTO;

public interface CadastroDeCartaServicePorta {
	String cadastrarCartas(List<TextoCartaRequestDTO> cartas, Long idBaralho);

	String cadastrarCarta(InformacaoParaCadastroDeCartaRequestDTO informacaoParaCadastroDeCartaDTO, Long idBaralho);

}
