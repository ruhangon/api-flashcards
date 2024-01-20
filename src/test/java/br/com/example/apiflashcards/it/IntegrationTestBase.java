package br.com.example.apiflashcards.it;

import java.util.ArrayList;
import java.util.List;

import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoComCartasRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.InformacoesParaCadastroDeBaralhoRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaRequestDTO;

public class IntegrationTestBase {

	protected CadastroDeBaralhoComCartasRequestDTO criarBaralhoComCartas() {
		CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO = new CadastroDeBaralhoComCartasRequestDTO();
		InformacoesParaCadastroDeBaralhoRequestDTO baralhoDTO = new InformacoesParaCadastroDeBaralhoRequestDTO();
		baralhoDTO.setNome("Meu baralho");
		baralhoDTO.setCartas(criarListaDeCartas());
		cadastroDeBaralhoDTO.setBaralho(baralhoDTO);
		return cadastroDeBaralhoDTO;
	}

	private List<TextoCartaRequestDTO> criarListaDeCartas() {
		List<TextoCartaRequestDTO> listaCartas = new ArrayList<>();
		TextoCartaRequestDTO carta1 = new TextoCartaRequestDTO();
		carta1.setFrente("info para frente 1");
		carta1.setTras("info para tras 1");
		listaCartas.add(carta1);
		TextoCartaRequestDTO carta2 = new TextoCartaRequestDTO();
		carta2.setFrente("info para frente 2");
		carta2.setTras("info para tras 2");
		listaCartas.add(carta2);
		return listaCartas;
	}

}
