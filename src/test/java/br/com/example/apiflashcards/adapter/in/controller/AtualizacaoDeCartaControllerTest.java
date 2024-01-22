package br.com.example.apiflashcards.adapter.in.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.adapter.in.model.dto.AtualizacaoDeCartaRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.InformacaoParaAtualizacaoDeCartaRequestDTO;
import br.com.example.apiflashcards.domain.ports.in.AtualizacaoDeCartaServicePorta;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class AtualizacaoDeCartaControllerTest {
	@Mock
	private AtualizacaoDeCartaServicePorta mkService;

	@InjectMocks
	private AtualizacaoDeCartaController controller;

	private static final Long ID_CARTA = 1L;
	private static final Integer INFO_AVALIACAO = 1;
	private AtualizacaoDeCartaRequestDTO atualizacaoDeCartaDTO;

	@BeforeEach
	public void setup() {
		atualizacaoDeCartaDTO = new AtualizacaoDeCartaRequestDTO();
	}

	@DisplayName("realiza a atualização da fila de uma carta usando mock, com sucesso")
	@Test
	void deve_atualizar_a_fila_de_uma_carta() {
		InformacaoParaAtualizacaoDeCartaRequestDTO informacaoParaCartaDTO = new InformacaoParaAtualizacaoDeCartaRequestDTO();
		informacaoParaCartaDTO.setAvaliacao(INFO_AVALIACAO);
		atualizacaoDeCartaDTO.setCarta(informacaoParaCartaDTO);

		when(mkService.atualizarFilaDeCarta(ID_CARTA, INFO_AVALIACAO)).thenReturn(HttpStatus.OK.getReasonPhrase());

		String controllerResponse = controller.atualizarFilaDaCarta(ID_CARTA, atualizacaoDeCartaDTO);

		assertEquals(controllerResponse, HttpStatus.OK.getReasonPhrase());

		verify(mkService).atualizarFilaDeCarta(ID_CARTA, INFO_AVALIACAO);
	}

}
