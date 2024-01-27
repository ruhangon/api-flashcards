package br.com.example.apiflashcards.adapter.in.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.apiflashcards.adapter.in.model.dto.InformacaoParaCadastroDeCartaRequestDTO;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeCartaServicePorta;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/baralho")
public class CadastroDeCartaController {
	private final CadastroDeCartaServicePorta cadastroDeCartaServicePorta;

	public CadastroDeCartaController(CadastroDeCartaServicePorta cadastroDeCartaServicePorta) {
		this.cadastroDeCartaServicePorta = cadastroDeCartaServicePorta;
	}

	@PostMapping(value = "/{id-baralho}/carta/cadastrar")
	public ResponseEntity<String> cadastrarCarta(@PathVariable("id-baralho") Long idBaralho,
			@RequestBody @Valid InformacaoParaCadastroDeCartaRequestDTO informacaoParaCadastroDeCartaDTO) {
		String cadastroDeCartaResponse = cadastroDeCartaServicePorta.cadastrarCarta(informacaoParaCadastroDeCartaDTO,
				idBaralho);
		return ResponseEntity.status(HttpStatus.CREATED).body(cadastroDeCartaResponse);
	}

}
