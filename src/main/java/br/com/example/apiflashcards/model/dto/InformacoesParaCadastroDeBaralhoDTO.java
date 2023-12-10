package br.com.example.apiflashcards.model.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InformacoesParaCadastroDeBaralhoDTO(
		@NotBlank String nome,
		@Size(min = 1) List<TextoCartaDTO> cartas
		) {}
