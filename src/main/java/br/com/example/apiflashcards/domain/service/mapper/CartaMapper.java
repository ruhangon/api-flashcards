package br.com.example.apiflashcards.domain.service.mapper;

import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaDTO;
import br.com.example.apiflashcards.domain.Carta;

public class CartaMapper {
	public Carta toCarta(TextoCartaDTO textoCartaDTO) {
		Carta carta = new Carta();
		carta.setFrente(textoCartaDTO.frente());
		carta.setTras(textoCartaDTO.tras());
		carta.setFila(1);
		return carta;
	}

}
