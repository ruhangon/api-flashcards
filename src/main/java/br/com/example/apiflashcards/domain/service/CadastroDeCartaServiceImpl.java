package br.com.example.apiflashcards.domain.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.adapter.in.model.dto.InformacaoParaCadastroDeCartaRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaRequestDTO;
import br.com.example.apiflashcards.domain.model.Carta;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeCartaServicePorta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeCartaRepositoryPorta;

public class CadastroDeCartaServiceImpl implements CadastroDeCartaServicePorta {
	private static final Integer VALOR_INICIAL_DE_FILA_PARA_NOVA_CARTA = 1;

	private final CadastroDeCartaRepositoryPorta cadastroDeCartaRepositoryPorta;

	public CadastroDeCartaServiceImpl(CadastroDeCartaRepositoryPorta cadastroDeCartaRepositoryPorta) {
		this.cadastroDeCartaRepositoryPorta = cadastroDeCartaRepositoryPorta;
	}

	@Override
	public String cadastrarCartas(List<TextoCartaRequestDTO> cartas, Long idBaralho) {
		cartas.forEach((TextoCartaRequestDTO textoCartaDTO) -> {
			Carta carta = new Carta(textoCartaDTO.getFrente(), textoCartaDTO.getTras(),
					VALOR_INICIAL_DE_FILA_PARA_NOVA_CARTA);
			cadastroDeCartaRepositoryPorta.save(carta, idBaralho);
		});
		return HttpStatus.CREATED.getReasonPhrase();
	}

	@Override
	public String cadastrarCarta(InformacaoParaCadastroDeCartaRequestDTO informacaoParaCadastroDeCartaDTO,
			Long idBaralho) {
		Carta carta = new Carta(informacaoParaCadastroDeCartaDTO.getCarta().getFrente(),
				informacaoParaCadastroDeCartaDTO.getCarta().getTras(), VALOR_INICIAL_DE_FILA_PARA_NOVA_CARTA);
		cadastroDeCartaRepositoryPorta.save(carta, idBaralho);
		return HttpStatus.CREATED.getReasonPhrase();
	}

}
