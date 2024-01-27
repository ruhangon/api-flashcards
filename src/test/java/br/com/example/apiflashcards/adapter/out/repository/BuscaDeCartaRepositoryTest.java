package br.com.example.apiflashcards.adapter.out.repository;

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

import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class BuscaDeCartaRepositoryTest {
	@Mock
	private SpringBuscaDeCartaRepository mkSpringBuscaDeCartaRepository;

	@InjectMocks
	private BuscaDeCartaRepository repository;

	private CartaEntity cartaEntity;

	private static final Long ID_CARTA = 1L;
	private static final Integer INFO_FILA = 1;
	private static final Long ID_BARALHO = 1L;
	private static final Long QUANTIDADE_CARTAS_DO_BARALHO = 2L;

	@BeforeEach
	public void setup() {
		cartaEntity = new CartaEntity();
		cartaEntity.setFila(INFO_FILA);
	}

	@DisplayName("realiza a busca de uma carta usando mock, com sucesso")
	@Test
	void deve_buscar_uma_carta_com_sucesso() {
		when(mkSpringBuscaDeCartaRepository.getById(ID_CARTA)).thenReturn(cartaEntity);

		CartaEntity repositoryResponse = repository.getById(ID_CARTA);

		assertEquals(repositoryResponse, cartaEntity);

		verify(mkSpringBuscaDeCartaRepository).getById(ID_CARTA);
	}

	@DisplayName("realiza a busca da fila de uma carta usando mock, com sucesso")
	@Test
	void deve_buscar_a_fila_de_uma_carta_com_sucesso() {
		when(mkSpringBuscaDeCartaRepository.getById(ID_CARTA)).thenReturn(cartaEntity);

		Integer repositoryResponse = repository.findFila(ID_CARTA);

		assertEquals(repositoryResponse, INFO_FILA);

		verify(mkSpringBuscaDeCartaRepository).getById(ID_CARTA);
	}

	@DisplayName("realiza a contagem de cartas de um baralho usando mock, com sucesso")
	@Test
	void deve_contar_cartas_de_um_baralho_com_sucesso() {
		when(mkSpringBuscaDeCartaRepository.countCartasBaralho(ID_BARALHO)).thenReturn(QUANTIDADE_CARTAS_DO_BARALHO);

		Long repositoryResponse = repository.countCartasBaralho(ID_BARALHO);

		assertEquals(repositoryResponse, QUANTIDADE_CARTAS_DO_BARALHO);

		verify(mkSpringBuscaDeCartaRepository).countCartasBaralho(ID_BARALHO);
	}

}
