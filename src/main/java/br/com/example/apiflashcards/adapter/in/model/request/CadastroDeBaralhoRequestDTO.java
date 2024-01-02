package br.com.example.apiflashcards.adapter.in.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class CadastroDeBaralhoRequestDTO {
    @NotNull(message = "O campo baralho não pode ser nulo")
    @Valid
    private InformacoesParaCadastroDeBaralhoRequestDTO baralho;

    public InformacoesParaCadastroDeBaralhoRequestDTO getBaralho() {
        return baralho;
    }

    public void setBaralho(InformacoesParaCadastroDeBaralhoRequestDTO baralho) {
        this.baralho = baralho;
    }

}
