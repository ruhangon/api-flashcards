package br.com.example.apiflashcards.domain.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaRequestDTO;
import br.com.example.apiflashcards.domain.model.Carta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeCartaRepositoryPorta;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class CadastroDeCartaServiceImplTest {
	@Mock
	private CadastroDeCartaRepositoryPorta mkCadastroDeCartaRepositoryPorta;

	@InjectMocks
	private CadastroDeCartaServiceImpl service;

	private static final Long ID_BARALHO = 1L;
	private static final Integer CARTA_FILA_RESPOSTA = 1;

	@Captor
	private ArgumentCaptor<Carta> cartaCaptor;

	@DisplayName("realiza o cadastro de duas cartas em um baralho usando mock, com sucesso")
	@Test
	void deve_cadastrar_lista_de_cartas_em_um_baralho_com_sucesso() {
		List<TextoCartaRequestDTO> listaCartas = criarListaDeCartas();

		String serviceResponse = service.cadastrarCartas(listaCartas, ID_BARALHO);

		assertEquals(serviceResponse, HttpStatus.CREATED.getReasonPhrase());

		verify(mkCadastroDeCartaRepositoryPorta, times(2)).save(cartaCaptor.capture(), eq(ID_BARALHO));

		assertAll(() -> assertEquals(cartaCaptor.getAllValues().get(0).getFrente(), listaCartas.get(0).getFrente()),
				() -> assertEquals(cartaCaptor.getAllValues().get(0).getTras(), listaCartas.get(0).getTras()),
				() -> assertEquals(cartaCaptor.getAllValues().get(0).getFila(), CARTA_FILA_RESPOSTA));

		assertAll(() -> assertEquals(cartaCaptor.getAllValues().get(1).getFrente(), listaCartas.get(1).getFrente()),
				() -> assertEquals(cartaCaptor.getAllValues().get(1).getTras(), listaCartas.get(1).getTras()),
				() -> assertEquals(cartaCaptor.getAllValues().get(1).getFila(), CARTA_FILA_RESPOSTA));
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
