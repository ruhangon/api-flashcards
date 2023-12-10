package br.com.example.apiflashcards.model.dto;

import jakarta.validation.constraints.NotNull;

public record CadastroDeBaralhoDTO(
		@NotNull InformacoesParaCadastroDeBaralhoDTO baralho
) {}
