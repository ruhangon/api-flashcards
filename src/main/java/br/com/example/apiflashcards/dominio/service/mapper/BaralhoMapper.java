package br.com.example.apiflashcards.dominio.service.mapper;

import br.com.example.apiflashcards.adaptador.entrada.model.dto.CadastroDeBaralhoDTO;
import br.com.example.apiflashcards.dominio.Baralho;

public class BaralhoMapper {
	public Baralho toBaralho(CadastroDeBaralhoDTO cadastroDeBaralhoDTO) {
		Baralho baralho = new Baralho();
		baralho.setNome(cadastroDeBaralhoDTO.baralho().nome());
		return baralho;
	}

}
