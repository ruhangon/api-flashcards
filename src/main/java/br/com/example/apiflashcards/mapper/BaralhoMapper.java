package br.com.example.apiflashcards.mapper;

import br.com.example.apiflashcards.model.Baralho;
import br.com.example.apiflashcards.model.dto.CadastroDeBaralhoDTO;

public class BaralhoMapper {
	public Baralho toBaralho(CadastroDeBaralhoDTO cadastroDeBaralhoDTO) {
		Baralho baralho = new Baralho();
		baralho.setNome(cadastroDeBaralhoDTO.baralho().nome());
		return baralho;
	}

}
