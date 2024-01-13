package br.com.example.apiflashcards.adapter.out.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class BuscaDeBaralhoRepositoryTest {
	@Mock
	private SpringBuscaDeBaralhoRepository mkSpringBuscaDeBaralhoRepository;

	@InjectMocks
	private BuscaDeBaralhoRepository repository;

	private static final Long ID_BARALHO = 1L;

	@DisplayName("realiza a busca de um baralho pelo seu identificador usando mock, com sucesso")
	@Test
	void deve_buscar_um_baralho_pelo_seu_id_com_sucesso() {
		BaralhoEntity baralhoResponse = new BaralhoEntity();

		when(mkSpringBuscaDeBaralhoRepository.getById(ID_BARALHO)).thenReturn(baralhoResponse);

		BaralhoEntity repositoryResponse = repository.getById(ID_BARALHO);

		assertEquals(repositoryResponse, baralhoResponse);

		verify(mkSpringBuscaDeBaralhoRepository).getById(ID_BARALHO);
	}

}
