package br.com.example.apiflashcards.adapter.out.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.adapter.out.entity.CartaEntity;
import br.com.example.apiflashcards.domain.model.Carta;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeBaralhoRepositoryPorta;

@ExtendWith(MockitoExtension.class)
public class CadastroDeCartaRepositoryTest {
	@Mock
	private SpringCadastroDeCartaRepository mkSpringCadastroDeCartaRepository;
	@Mock
	private BuscaDeBaralhoRepositoryPorta mkBuscaDeBaralhoRepositoryPorta;

	@InjectMocks
	private CadastroDeCartaRepository repository;

	private Carta carta;
	private BaralhoEntity baralhoEntity;

	private static final Long ID_BARALHO = 1L;
	private static final String INFO_PARA_FRENTE_DA_CARTA = "frente da carta";
	private static final String INFO_PARA_TRAS_DA_CARTA = "tras da carta";
	private static final Integer INFO_PARA_FILA_DA_CARTA = 1;

	@BeforeEach
	public void setup() {
		carta = new Carta(INFO_PARA_FRENTE_DA_CARTA, INFO_PARA_TRAS_DA_CARTA, INFO_PARA_FILA_DA_CARTA);
		baralhoEntity = new BaralhoEntity();
	}

	@DisplayName("realiza o cadastro de uma carta com frente e traz usando mock, com sucesso")
	@Test
	void deve_cadastrar_uma_carta_com_sucesso() {
		when(mkBuscaDeBaralhoRepositoryPorta.getById(ID_BARALHO)).thenReturn(baralhoEntity);

		CartaEntity cartaEntity = new CartaEntity(carta.getFrente(), carta.getTras(), carta.getFila(), baralhoEntity);
		cartaEntity.setId(1L);

		when(mkSpringCadastroDeCartaRepository.save(any(CartaEntity.class))).thenReturn(cartaEntity);

		Carta repositoryResponse = repository.save(carta, ID_BARALHO);

		assertEquals(repositoryResponse.getId(), cartaEntity.getId());
		assertEquals(repositoryResponse.getFrente(), cartaEntity.getFrente());
		assertEquals(repositoryResponse.getTras(), cartaEntity.getTras());
		assertEquals(repositoryResponse.getFila(), cartaEntity.getFila());

		verify(mkBuscaDeBaralhoRepositoryPorta).getById(ID_BARALHO);
		verify(mkSpringCadastroDeCartaRepository).save(any(CartaEntity.class));
	}

}
