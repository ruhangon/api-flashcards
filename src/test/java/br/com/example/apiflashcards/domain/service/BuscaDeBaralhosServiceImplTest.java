package br.com.example.apiflashcards.domain.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.example.apiflashcards.adapter.in.model.dto.ConsultaDeBaralhosDTO;
import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeBaralhosRepositoryPorta;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class BuscaDeBaralhosServiceImplTest {
	@Mock
	private BuscaDeBaralhosRepositoryPorta mkBuscaDeBaralhosRepositoryPorta;

	@InjectMocks
	private BuscaDeBaralhosServiceImpl service;

	private static final Long ID_BARALHO_1 = 1L;
	private static final String NOME_BARALHO_1 = "ingles";
	private static final Integer QTD_CARTAS_BARALHO_1 = 1;
	private static final Long ID_CARTA_1 = 1L;
	private static final String FRENTE_CARTA_1 = "frente 1";
	private static final String TRAS_CARTA_1 = "tras 1";
	private static final Integer FILA_CARTA_1 = 1;

	@DisplayName("realiza a consulta de informações dos baralhos cadastrados usando mocks, com sucesso")
	@Test
	void deve_consultar_informacoes_de_baralhos_com_sucesso() {
		List<BaralhoEntity> listaBaralhosResponse = gerarListaDeBaralhos();

		when(mkBuscaDeBaralhosRepositoryPorta.buscarBaralhos()).thenReturn(listaBaralhosResponse);

		ConsultaDeBaralhosDTO serviceResponse = service.consultarInformacoes();

		assertAll(() -> assertEquals(serviceResponse.informacoesDeBaralhosDTO().get(0).nome(), NOME_BARALHO_1),
				() -> assertEquals(serviceResponse.informacoesDeBaralhosDTO().get(0).quantidadeCartas(),
						QTD_CARTAS_BARALHO_1));

		verify(mkBuscaDeBaralhosRepositoryPorta).buscarBaralhos();
	}

	private List<BaralhoEntity> gerarListaDeBaralhos() {
		List<BaralhoEntity> listaBaralhos = new ArrayList<>();
		BaralhoEntity baralho1 = new BaralhoEntity();
		baralho1.setId(ID_BARALHO_1);
		baralho1.setNome(NOME_BARALHO_1);
		List<CartaEntity> listaCartas = gerarListaDeCartas(baralho1);
		baralho1.setCartas(listaCartas);
		listaBaralhos.add(baralho1);
		return listaBaralhos;
	}

	private List<CartaEntity> gerarListaDeCartas(BaralhoEntity baralho1) {
		List<CartaEntity> listaCartas = new ArrayList<>();
		CartaEntity carta1 = new CartaEntity();
		carta1.setId(ID_CARTA_1);
		carta1.setFrente(FRENTE_CARTA_1);
		carta1.setTras(TRAS_CARTA_1);
		carta1.setFila(FILA_CARTA_1);
		carta1.setBaralho(baralho1);
		listaCartas.add(carta1);
		return listaCartas;
	}

}
