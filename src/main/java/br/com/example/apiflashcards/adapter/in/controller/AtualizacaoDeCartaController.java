package br.com.example.apiflashcards.adapter.in.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.apiflashcards.adapter.in.model.dto.AtualizacaoDeCartaRequestDTO;
import br.com.example.apiflashcards.domain.ports.in.AtualizacaoDeCartaServicePorta;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/carta")
public class AtualizacaoDeCartaController {
	private final AtualizacaoDeCartaServicePorta atualizacaoDeCartaServicePorta;

	public AtualizacaoDeCartaController(AtualizacaoDeCartaServicePorta atualizacaoDeCartaServicePorta) {
		this.atualizacaoDeCartaServicePorta = atualizacaoDeCartaServicePorta;
	}

	@PatchMapping(value = "/{id-carta}/fila/atualizar")
	public String atualizarFilaDaCarta(@PathVariable("id-carta") Long idCarta,
			@RequestBody @Valid AtualizacaoDeCartaRequestDTO atualizacaoDeCartaRequestDTO) {
		String atualizacaoDeCartaResponse = atualizacaoDeCartaServicePorta.atualizarFilaDeCarta(idCarta,
				atualizacaoDeCartaRequestDTO.getCarta().getAvaliacao());
		return atualizacaoDeCartaResponse;
	}

}
