package br.com.example.apiflashcards.model.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroDeBaralhoDTO(
		@NotBlank String nome,
		@Size(min=1) List<TextoCartaDTO> listaTextoCarta
) {}
