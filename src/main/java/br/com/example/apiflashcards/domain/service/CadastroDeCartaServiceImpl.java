package br.com.example.apiflashcards.domain.service;

import java.util.List;

import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaDTO;
import br.com.example.apiflashcards.domain.Carta;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeCartaServicePorta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeCartaRepositoryPorta;

public class CadastroDeCartaServiceImpl implements CadastroDeCartaServicePorta {
	private static final Integer VALOR_INICIAL_DE_FILA_PARA_NOVA_CARTA = 1;

	private final CadastroDeCartaRepositoryPorta cadastroDeCartaRepositoryPorta;

	public CadastroDeCartaServiceImpl(CadastroDeCartaRepositoryPorta cadastroDeCartaRepositoryPorta) {
		this.cadastroDeCartaRepositoryPorta = cadastroDeCartaRepositoryPorta;
	}

	@Override
	public void cadastrarCartas(List<TextoCartaDTO> cartas, Long idBaralho) {
		cartas.forEach((TextoCartaDTO textoCartaDTO) -> {
			Carta carta = new Carta(textoCartaDTO.getFrente(), textoCartaDTO.getTras(), VALOR_INICIAL_DE_FILA_PARA_NOVA_CARTA);
			cadastroDeCartaRepositoryPorta.save(carta, idBaralho);
		});
	}

}
