package br.com.example.apiflashcards.adapter.in.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.apiflashcards.adapter.in.model.request.CadastroDeBaralhoRequestDTO;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeBaralhoServicePorta;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/baralhos")
public class CadastroDeBaralhoController {
	private final CadastroDeBaralhoServicePorta cadastroDeBaralhoServicePorta;

	public CadastroDeBaralhoController(CadastroDeBaralhoServicePorta cadastroDeBaralhoServicePorta) {
		this.cadastroDeBaralhoServicePorta = cadastroDeBaralhoServicePorta;
	}

	@PostMapping(value = "/cadastrar")
	public ResponseEntity<String> cadastrarBaralho(@RequestBody @Valid CadastroDeBaralhoRequestDTO cadastroDeBaralhoDTO) {
		String cadastroDeBaralhoResponse = cadastroDeBaralhoServicePorta.cadastrarBaralho(cadastroDeBaralhoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(cadastroDeBaralhoResponse);
	}

}
