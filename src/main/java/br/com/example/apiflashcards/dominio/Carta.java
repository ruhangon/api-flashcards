package br.com.example.apiflashcards.dominio;

public class Carta {
	private Long id;
	private String frente;
	private String tras;
	private Integer fila;

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

}
