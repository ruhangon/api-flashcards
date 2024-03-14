package br.com.example.apiflashcards.adapter.in.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import br.com.example.apiflashcards.adapter.in.model.dto.InformacoesParaConsultaDeBaralhoDTO;
import br.com.example.apiflashcards.domain.ports.in.BuscaDeBaralhosServicePorta;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class BuscaDeBaralhosControllerTest {
	@Mock
	private BuscaDeBaralhosServicePorta mkService;

	@InjectMocks
	private BuscaDeBaralhosController controller;

	private static final String NOME_BARALHO_1 = "ingles";
	private static final Integer QTD_CARTAS_BARALHO_1 = 50;
	private static final String NOME_BARALHO_2 = "espanhol";
	private static final Integer QTD_CARTAS_BARALHO_2 = 40;

	@DisplayName("realiza a consulta de informações dos baralhos do usuário usando mock, com sucesso")
	@Test
	void deve_consultar_informacoes_dos_baralhos_com_sucesso() {
		ConsultaDeBaralhosDTO consultaDeBaralhosDTO = gerarBaralhos();

		when(mkService.consultarInformacoes()).thenReturn(consultaDeBaralhosDTO);

		ConsultaDeBaralhosDTO controllerResponse = controller.consultarInformacoesDeBaralhos();

		assertNotNull(controllerResponse);
		assertAll(() -> assertEquals(controllerResponse.informacoesDeBaralhosDTO().get(0).nome(), NOME_BARALHO_1),
				() -> assertEquals(controllerResponse.informacoesDeBaralhosDTO().get(0).quantidadeCartas(),
						QTD_CARTAS_BARALHO_1),
				() -> assertEquals(controllerResponse.informacoesDeBaralhosDTO().get(1).nome(), NOME_BARALHO_2),
				() -> assertEquals(controllerResponse.informacoesDeBaralhosDTO().get(1).quantidadeCartas(),
						QTD_CARTAS_BARALHO_2));

		verify(mkService).consultarInformacoes();
	}

	private ConsultaDeBaralhosDTO gerarBaralhos() {
		List<InformacoesParaConsultaDeBaralhoDTO> listaInformacoesParaConsultaDeBaralhosDTO = new ArrayList<>();
		listaInformacoesParaConsultaDeBaralhosDTO
				.add(new InformacoesParaConsultaDeBaralhoDTO(NOME_BARALHO_1, QTD_CARTAS_BARALHO_1));
		listaInformacoesParaConsultaDeBaralhosDTO
				.add(new InformacoesParaConsultaDeBaralhoDTO(NOME_BARALHO_2, QTD_CARTAS_BARALHO_2));
		ConsultaDeBaralhosDTO consultaDeBaralhosDTO = new ConsultaDeBaralhosDTO(
				listaInformacoesParaConsultaDeBaralhosDTO);
		return consultaDeBaralhosDTO;
	}

}
