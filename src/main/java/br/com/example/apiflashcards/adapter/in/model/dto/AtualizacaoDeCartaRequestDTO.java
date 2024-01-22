package br.com.example.apiflashcards.adapter.in.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class AtualizacaoDeCartaRequestDTO {
	@NotNull(message = "O campo carta não pode ser nulo")
	@Valid
	private InformacaoParaAtualizacaoDeCartaRequestDTO carta;

	public InformacaoParaAtualizacaoDeCartaRequestDTO getCarta() {
		return carta;
	}

	public void setCarta(InformacaoParaAtualizacaoDeCartaRequestDTO carta) {
		this.carta = carta;
	}

}
