package br.com.example.apiflashcards.adapter.in.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class InformacaoParaAtualizacaoDeCartaRequestDTO {
	@Min(value = 1, message = "o campo avaliacao não pode ser menor que 1")
	@Max(value = 5, message = "o campo avaliacao não pode ser maior que 5")
	private Integer avaliacao;

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

}
