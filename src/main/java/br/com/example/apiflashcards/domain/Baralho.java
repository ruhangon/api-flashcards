package br.com.example.apiflashcards.domain;

import java.util.List;

import br.com.example.apiflashcards.adapter.in.model.request.CadastroDeBaralhoRequestDTO;

public class Baralho {
	private Long id;
	private String nome;
	private List<Carta> cartas;

	public Baralho() {
	}

	public Baralho(CadastroDeBaralhoRequestDTO cadastroDeBaralhoDTO) {
		this.nome = cadastroDeBaralhoDTO.getBaralho().getNome();
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

}
