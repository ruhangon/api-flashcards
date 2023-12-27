package br.com.example.apiflashcards.domain.service;

import java.util.List;

import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaDTO;
import br.com.example.apiflashcards.domain.Carta;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeCartaServicePorta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeCartaRepositoryPorta;
import br.com.example.apiflashcards.domain.service.mapper.CartaMapper;

public class CadastroDeCartaServiceImpl implements CadastroDeCartaServicePorta {
	private final CadastroDeCartaRepositoryPorta cadastroDeCartaRepositoryPorta;

	public CadastroDeCartaServiceImpl(CadastroDeCartaRepositoryPorta cadastroDeCartaRepositoryPorta) {
		this.cadastroDeCartaRepositoryPorta = cadastroDeCartaRepositoryPorta;
	}

	@Override
	public void cadastrarCartas(List<TextoCartaDTO> cartas, Long idBaralho) {
		CartaMapper cartaMapper = new CartaMapper();
		cartas.forEach((TextoCartaDTO textoCartaDTO) -> {
			Carta carta = cartaMapper.toCarta(textoCartaDTO);
			cadastroDeCartaRepositoryPorta.save(carta, idBaralho);
		});
	}

}
