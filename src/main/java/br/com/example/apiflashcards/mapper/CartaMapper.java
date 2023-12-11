package br.com.example.apiflashcards.mapper;

import br.com.example.apiflashcards.model.Baralho;
import br.com.example.apiflashcards.model.Carta;
import br.com.example.apiflashcards.model.dto.TextoCartaDTO;

public class CartaMapper {
	public Carta toCarta(TextoCartaDTO textoCartaDTO, Baralho baralho) {
		Carta carta = new Carta();
		carta.setFrente(textoCartaDTO.frente());
		carta.setTras(textoCartaDTO.tras());
		carta.setFila(1);
		carta.setBaralho(baralho);
		return carta;
	}

}
