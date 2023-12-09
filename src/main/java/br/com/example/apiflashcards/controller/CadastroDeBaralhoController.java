package br.com.example.apiflashcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.apiflashcards.model.dto.CadastroDeBaralhoDTO;
import br.com.example.apiflashcards.service.CadastroDeBaralhoService;

@RestController
@RequestMapping("/baralhos")
public class CadastroDeBaralhoController {
	private final CadastroDeBaralhoService cadastroDeBaralhoService;

	@Autowired
	public CadastroDeBaralhoController(CadastroDeBaralhoService cadastroDeBaralhoService) {
		this.cadastroDeBaralhoService = cadastroDeBaralhoService;
	}

	@PostMapping(value = "/cadastrar")
	public ResponseEntity<String> cadastrarBaralho(@RequestBody CadastroDeBaralhoDTO cadastroDeBaralhoDTO) {
		String cadastroDeBaralhoResponse = cadastroDeBaralhoService.cadastrarBaralho(cadastroDeBaralhoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(cadastroDeBaralhoResponse);
	}

}
