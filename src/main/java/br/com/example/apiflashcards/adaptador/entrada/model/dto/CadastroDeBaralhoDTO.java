package br.com.example.apiflashcards.adaptador.entrada.model.dto;

import jakarta.validation.constraints.NotNull;

public record CadastroDeBaralhoDTO(@NotNull InformacoesParaCadastroDeBaralhoDTO baralho) {
}
