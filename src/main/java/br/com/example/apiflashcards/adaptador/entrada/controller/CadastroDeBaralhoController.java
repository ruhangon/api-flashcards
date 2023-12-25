package br.com.example.apiflashcards.adaptador.entrada.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.apiflashcards.adaptador.entrada.model.dto.CadastroDeBaralhoDTO;
import br.com.example.apiflashcards.dominio.portas.entrada.CadastroDeBaralhoServicePorta;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/baralhos")
public class CadastroDeBaralhoController {
	private final CadastroDeBaralhoServicePorta cadastroDeBaralhoServicePorta;

	public CadastroDeBaralhoController(CadastroDeBaralhoServicePorta cadastroDeBaralhoServicePorta) {
		this.cadastroDeBaralhoServicePorta = cadastroDeBaralhoServicePorta;
	}

	@PostMapping(value = "/cadastrar")
	public ResponseEntity<String> cadastrarBaralho(@RequestBody @Valid CadastroDeBaralhoDTO cadastroDeBaralhoDTO) {
		String cadastroDeBaralhoResponse = cadastroDeBaralhoServicePorta.cadastrarBaralho(cadastroDeBaralhoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(cadastroDeBaralhoResponse);
	}

}
