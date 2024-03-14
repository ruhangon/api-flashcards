package br.com.example.apiflashcards.adapter.out.repository;

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

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class BuscaDeBaralhosRepositoryTest {
	@Mock
	private SpringBuscaDeBaralhoRepository mkSpringBuscaDeBaralhoRepository;

	@InjectMocks
	private BuscaDeBaralhosRepository repository;

	private static final Long ID_BARALHO_1 = 1L;
	private static final String NOME_BARALHO_1 = "ingles";

	@DisplayName("realiza a consulta de informações dos baralhos cadastrados usando mock, com sucesso")
	@Test
	void deve_consultar_informacoes_dos_baralhos_com_sucesso() {
		List<BaralhoEntity> listaBaralhosResponse = gerarListaDeBaralhos();

		when(mkSpringBuscaDeBaralhoRepository.findAll()).thenReturn(listaBaralhosResponse);

		List<BaralhoEntity> repositoryResponse = repository.buscarBaralhos();

		assertEquals(repositoryResponse, listaBaralhosResponse);

		verify(mkSpringBuscaDeBaralhoRepository).findAll();
	}

	private List<BaralhoEntity> gerarListaDeBaralhos() {
		List<BaralhoEntity> listaBaralhos = new ArrayList<>();
		BaralhoEntity baralho1 = new BaralhoEntity();
		baralho1.setId(ID_BARALHO_1);
		baralho1.setNome(NOME_BARALHO_1);
		baralho1.setCartas(new ArrayList<CartaEntity>());
		listaBaralhos.add(baralho1);
		return listaBaralhos;
	}

}
