package br.com.example.apiflashcards.domain.classes.in;

import java.util.List;

import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaDTO;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeCartaServicePorta;

public class FakeCadastroDeCartaServiceImpl implements CadastroDeCartaServicePorta {

	@Override
	public void cadastrarCartas(List<TextoCartaDTO> cartas, Long idBaralho) {
	}

}
