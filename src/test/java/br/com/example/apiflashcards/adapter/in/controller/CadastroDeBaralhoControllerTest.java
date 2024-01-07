package br.com.example.apiflashcards.adapter.in.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoComCartasRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.InformacoesParaCadastroDeBaralhoRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaRequestDTO;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeBaralhoServicePorta;

@ExtendWith(MockitoExtension.class)
public class CadastroDeBaralhoControllerTest {
	@Mock
	private CadastroDeBaralhoServicePorta mkService;

	@InjectMocks
	private CadastroDeBaralhoController controller;

	private CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO;

	@BeforeEach
	public void setup() {
		cadastroDeBaralhoDTO = new CadastroDeBaralhoComCartasRequestDTO();
	}

	@DisplayName("realiza o cadastro de um baralho com duas cartas usando mock, com sucesso")
	@Test
	void deve_cadastrar_um_baralho_com_duas_cartas_com_sucesso() {
		InformacoesParaCadastroDeBaralhoRequestDTO baralhoDTO = new InformacoesParaCadastroDeBaralhoRequestDTO();
		baralhoDTO.setNome("Meu baralho");
		baralhoDTO.setCartas(criarListaDeCartas());
		cadastroDeBaralhoDTO.setBaralho(baralhoDTO);

		when(mkService.cadastrarBaralhoComCartas(cadastroDeBaralhoDTO))
				.thenReturn(HttpStatus.CREATED.getReasonPhrase());

		ResponseEntity<String> controllerResponse = controller.cadastrarBaralhoComCartas(cadastroDeBaralhoDTO);

		assertEquals(controllerResponse.getStatusCode(), HttpStatus.CREATED);
		assertEquals(controllerResponse.getBody(), HttpStatus.CREATED.getReasonPhrase());

		verify(mkService).cadastrarBaralhoComCartas(cadastroDeBaralhoDTO);
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
