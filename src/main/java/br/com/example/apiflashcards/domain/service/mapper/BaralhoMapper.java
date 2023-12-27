package br.com.example.apiflashcards.domain.service.mapper;

import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoDTO;
import br.com.example.apiflashcards.domain.Baralho;

public class BaralhoMapper {
	public Baralho toBaralho(CadastroDeBaralhoDTO cadastroDeBaralhoDTO) {
		Baralho baralho = new Baralho();
		baralho.setNome(cadastroDeBaralhoDTO.baralho().nome());
		return baralho;
	}

}
