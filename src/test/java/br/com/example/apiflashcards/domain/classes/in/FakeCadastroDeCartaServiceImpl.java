package br.com.example.apiflashcards.domain.classes.in;

import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaRequestDTO;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeCartaServicePorta;

public class FakeCadastroDeCartaServiceImpl implements CadastroDeCartaServicePorta {

	@Override
	public String cadastrarCartas(List<TextoCartaRequestDTO> cartas, Long idBaralho) {
		return HttpStatus.CREATED.getReasonPhrase();
	}

}
