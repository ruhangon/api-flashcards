package br.com.example.apiflashcards.adapter.in.model.dto;

import jakarta.validation.constraints.NotNull;

public class InformacaoParaCadastroDeCartaRequestDTO {
	@NotNull(message = "O campo carta não pode ser nulo")
	private TextoCartaRequestDTO carta;

	public TextoCartaRequestDTO getCarta() {
		return carta;
	}

	public void setCarta(TextoCartaRequestDTO carta) {
		this.carta = carta;
	}

}
