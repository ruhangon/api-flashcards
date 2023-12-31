package br.com.example.apiflashcards.adapter.in.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class CadastroDeBaralhoDTO {
    @NotNull(message = "O campo baralho não pode ser nulo")
    @Valid
    private InformacoesParaCadastroDeBaralhoDTO baralho;

    public InformacoesParaCadastroDeBaralhoDTO getBaralho() {
        return baralho;
    }

    public void setBaralho(InformacoesParaCadastroDeBaralhoDTO baralho) {
        this.baralho = baralho;
    }

}
