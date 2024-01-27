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
import org.springframework.http.ResponseEntity;

import br.com.example.apiflashcards.adapter.in.model.dto.InformacaoParaCadastroDeCartaRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaRequestDTO;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeCartaServicePorta;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class CadastroDeCartaControllerTest {
	@Mock
	private CadastroDeCartaServicePorta mkService;

	@InjectMocks
	private CadastroDeCartaController controller;

	private InformacaoParaCadastroDeCartaRequestDTO informacaoParaCadastroDeCartaDTO;

	private static final Long ID_BARALHO = 1L;

	@BeforeEach
	public void setup() {
		informacaoParaCadastroDeCartaDTO = new InformacaoParaCadastroDeCartaRequestDTO();
	}

	@DisplayName("realiza o cadastro de uma carta em um baralho existente usando mock, com sucesso")
	@Test
	void deve_cadastrar_uma_carta_em_um_baralho_existente_com_sucesso() {
		TextoCartaRequestDTO carta = new TextoCartaRequestDTO();
		carta.setFrente("info para frente 1");
		carta.setTras("info para tras 1");
		informacaoParaCadastroDeCartaDTO.setCarta(carta);

		when(mkService.cadastrarCarta(informacaoParaCadastroDeCartaDTO, ID_BARALHO))
				.thenReturn(HttpStatus.CREATED.getReasonPhrase());

		ResponseEntity<String> controllerResponse = controller.cadastrarCarta(ID_BARALHO,
				informacaoParaCadastroDeCartaDTO);

		assertEquals(controllerResponse.getStatusCode(), HttpStatus.CREATED);
		assertEquals(controllerResponse.getBody(), HttpStatus.CREATED.getReasonPhrase());

		verify(mkService).cadastrarCarta(informacaoParaCadastroDeCartaDTO, ID_BARALHO);
	}

}
