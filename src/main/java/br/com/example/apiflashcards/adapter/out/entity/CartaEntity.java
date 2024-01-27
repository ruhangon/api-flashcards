package br.com.example.apiflashcards.adapter.out.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "carta")
@Table(name = "carta")
public class CartaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String frente;
	private String tras;
	private Integer fila;

	@ManyToOne
	@JoinColumn(name = "baralho_id")
	private BaralhoEntity baralho;

	public CartaEntity() {
	}

	public CartaEntity(String frente, String tras, Integer fila, BaralhoEntity baralhoEntity) {
		this.frente = frente;
		this.tras = tras;
		this.fila = fila;
		this.baralho = baralhoEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrente() {
		return frente;
	}

	public void setFrente(String frente) {
		this.frente = frente;
	}

	public String getTras() {
		return tras;
	}

	public void setTras(String tras) {
		this.tras = tras;
	}

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}

	public BaralhoEntity getBaralho() {
		return baralho;
	}

	public void setBaralho(BaralhoEntity baralho) {
		this.baralho = baralho;
	}

}
