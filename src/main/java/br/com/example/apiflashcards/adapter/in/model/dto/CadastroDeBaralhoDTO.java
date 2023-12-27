package br.com.example.apiflashcards.adapter.in.model.dto;

import jakarta.validation.constraints.NotNull;

public record CadastroDeBaralhoDTO(@NotNull InformacoesParaCadastroDeBaralhoDTO baralho) {
}
