package br.com.example.apiflashcards.dominio.service;

import java.util.List;

import br.com.example.apiflashcards.adaptador.entrada.model.dto.TextoCartaDTO;
import br.com.example.apiflashcards.dominio.Carta;
import br.com.example.apiflashcards.dominio.portas.entrada.CadastroDeCartaServicePorta;
import br.com.example.apiflashcards.dominio.portas.saida.CadastroDeCartaRepositoryPorta;
import br.com.example.apiflashcards.dominio.service.mapper.CartaMapper;

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
