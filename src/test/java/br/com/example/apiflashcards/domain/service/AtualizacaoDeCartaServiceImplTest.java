package br.com.example.apiflashcards.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import br.com.example.apiflashcards.domain.ports.out.AtualizacaoDeCartaRepositoryPorta;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeCartaRepositoryPorta;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class AtualizacaoDeCartaServiceImplTest {
	@Mock
	private AtualizacaoDeCartaRepositoryPorta mkAtualizacaoDeCartaRepositoryPorta;

	@Mock
	private BuscaDeCartaRepositoryPorta mkBuscaDeCartaRepositoryPorta;

	@InjectMocks
	private AtualizacaoDeCartaServiceImpl service;

	private static final Long ID_CARTA = 1L;
	private static final Integer FILA_INICIAL_PARA_CARTA = 1;
	private static final Integer INFO_AVALIACAO = 5;

	@Captor
	private ArgumentCaptor<Integer> novaFilaDaCartaCaptor;

	@DisplayName("realiza a atualização da fila de uma carta usando mocks, com sucesso")
	@Test
	void deve_atualizar_a_fila_de_uma_carta() {
		when(mkBuscaDeCartaRepositoryPorta.findFila(ID_CARTA)).thenReturn(FILA_INICIAL_PARA_CARTA);

		String serviceResponse = service.atualizarFilaDeCarta(ID_CARTA, INFO_AVALIACAO);

		assertEquals(serviceResponse, HttpStatus.OK.getReasonPhrase());

		verify(mkBuscaDeCartaRepositoryPorta).findFila(ID_CARTA);
		verify(mkAtualizacaoDeCartaRepositoryPorta).updateFila(eq(ID_CARTA), novaFilaDaCartaCaptor.capture());

		assertEquals(novaFilaDaCartaCaptor.getValue(), (FILA_INICIAL_PARA_CARTA + INFO_AVALIACAO));
	}

}
