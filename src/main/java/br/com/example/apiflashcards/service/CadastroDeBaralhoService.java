package br.com.example.apiflashcards.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.example.apiflashcards.model.dto.CadastroDeBaralhoDTO;

@Service
public class CadastroDeBaralhoService {

	public String cadastrarBaralho(CadastroDeBaralhoDTO cadastroDeBaralhoDTO) {
		return HttpStatus.CREATED.getReasonPhrase();
	}

}
