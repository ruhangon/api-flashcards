package br.com.example.apiflashcards.dominio.service.mapper;

import br.com.example.apiflashcards.adaptador.entrada.model.dto.TextoCartaDTO;
import br.com.example.apiflashcards.dominio.Carta;

public class CartaMapper {
	public Carta toCarta(TextoCartaDTO textoCartaDTO) {
		Carta carta = new Carta();
		carta.setFrente(textoCartaDTO.frente());
		carta.setTras(textoCartaDTO.tras());
		carta.setFila(1);
		return carta;
	}

}
