package br.com.example.apiflashcards.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.apiflashcards.mapper.CartaMapper;
import br.com.example.apiflashcards.model.Baralho;
import br.com.example.apiflashcards.model.Carta;
import br.com.example.apiflashcards.model.dto.TextoCartaDTO;
import br.com.example.apiflashcards.repository.CartaRepository;
import br.com.example.apiflashcards.service.CadastroDeCartaService;

@Service
public class CadastroDeCartaServiceImpl implements CadastroDeCartaService {
	private final CartaRepository cartaRepository;

	@Autowired
	public CadastroDeCartaServiceImpl(CartaRepository cartaRepository) {
		this.cartaRepository = cartaRepository;
	}

	@Override
	public void cadastrarCartas(List<TextoCartaDTO> cartas, Baralho baralho) {
		CartaMapper cartaMapper = new CartaMapper();
		cartas.forEach((TextoCartaDTO textoCartaDTO) -> {
			Carta carta = cartaMapper.toCarta(textoCartaDTO, baralho);
			cartaRepository.save(carta);
		});
	}

}
