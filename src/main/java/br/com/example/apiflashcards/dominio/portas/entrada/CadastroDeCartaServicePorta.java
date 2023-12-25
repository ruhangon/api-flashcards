package br.com.example.apiflashcards.dominio.portas.entrada;

import java.util.List;

import br.com.example.apiflashcards.adaptador.entrada.model.dto.TextoCartaDTO;

public interface CadastroDeCartaServicePorta {
	void cadastrarCartas(List<TextoCartaDTO> cartas, Long idBaralho);

}
