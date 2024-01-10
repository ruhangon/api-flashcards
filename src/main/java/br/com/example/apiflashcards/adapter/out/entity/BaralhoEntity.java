package br.com.example.apiflashcards.adapter.out.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "baralho")
public class BaralhoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "baralho")
	private List<CartaEntity> cartas = new ArrayList<>();

	public BaralhoEntity() {
	}

	public BaralhoEntity(String nome) {
		this.nome = nome;
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

	public List<CartaEntity> getCartas() {
		return cartas;
	}

	public void setCartas(List<CartaEntity> cartas) {
		this.cartas = cartas;
	}

}
