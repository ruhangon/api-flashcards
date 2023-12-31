package br.com.example.apiflashcards.adapter.in.model.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class InformacoesParaCadastroDeBaralhoDTO {
    @NotBlank(message = "O campo nome do baralho ão pode ser nulo ou vazio")
    private String nome;
    @Size(min = 1, message = "O baralho deve ter pelo menos uma carta")
    private List<TextoCartaDTO> cartas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TextoCartaDTO> getCartas() {
        return cartas;
    }

    public void setCartas(List<TextoCartaDTO> cartas) {
        this.cartas = cartas;
    }

}
