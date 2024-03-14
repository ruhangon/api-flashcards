package br.com.example.apiflashcards.adapter.in.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InformacoesParaConsultaDeBaralhoDTO(
		@JsonProperty("nome") String nome,
		@JsonProperty("quantidade_cartas") Integer quantidadeCartas
		) {}
