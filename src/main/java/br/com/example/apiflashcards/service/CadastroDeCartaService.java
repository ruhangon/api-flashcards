package br.com.example.apiflashcards.service;

import java.util.List;

import br.com.example.apiflashcards.model.Baralho;
import br.com.example.apiflashcards.model.dto.TextoCartaDTO;

public interface CadastroDeCartaService {
	void cadastrarCartas(List<TextoCartaDTO> cartas, Baralho baralho);

}
