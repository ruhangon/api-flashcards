package br.com.example.apiflashcards.adapter.out.repository;

import static org.mockito.ArgumentMatchers.any;
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

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class AtualizacaoDeCartaRepositoryTest {
	@Mock
	private SpringAtualizacaoDeCartaRepository mkSpringAtualizacaoDeCartaRepository;

	@Mock
	private BuscaDeCartaRepository mkBuscaDeCartaRepository;

	@Mock
	private CartaEntity mkCartaEntity;

	@InjectMocks
	private AtualizacaoDeCartaRepository repository;

	private static final Long ID_CARTA = 1L;
	private static final Integer INFO_FILA = 1;
	private static final Integer INFO_NOVA_FILA = 2;

	@BeforeEach
	public void setup() {
		mkCartaEntity.setId(ID_CARTA);
		mkCartaEntity.setFrente("info para frente");
		mkCartaEntity.setTras("info para tras");
		mkCartaEntity.setFila(INFO_FILA);
		mkCartaEntity.setBaralho(new BaralhoEntity());

		when(mkBuscaDeCartaRepository.getById(ID_CARTA)).thenReturn(mkCartaEntity);
		when(mkSpringAtualizacaoDeCartaRepository.save(any(CartaEntity.class))).thenReturn(mkCartaEntity);
	}

	@DisplayName("realiza a atualização da fila de uma carta usando mock, com sucesso")
	@Test
	void deve_atualizar_a_fila_de_uma_carta_com_sucesso() {
		repository.updateFila(ID_CARTA, INFO_NOVA_FILA);

		verify(mkBuscaDeCartaRepository).getById(ID_CARTA);
		verify(mkSpringAtualizacaoDeCartaRepository).save(any(CartaEntity.class));
		verify(mkCartaEntity).setFila(INFO_NOVA_FILA);
	}

}
