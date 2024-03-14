package br.com.example.apiflashcards.adapter.in.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ConsultaDeBaralhosDTO(
		@JsonProperty("baralhos") List<InformacoesParaConsultaDeBaralhoDTO> informacoesDeBaralhosDTO
		) {}
