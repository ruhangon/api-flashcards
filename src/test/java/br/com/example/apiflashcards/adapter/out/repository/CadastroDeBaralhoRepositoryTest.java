package br.com.example.apiflashcards.adapter.out.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import br.com.example.apiflashcards.domain.model.Baralho;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class CadastroDeBaralhoRepositoryTest {
	@Mock
	private SpringCadastroDeBaralhoRepository mkSpringCadastroDeBaralhoRepository;

	@InjectMocks
	private CadastroDeBaralhoRepository repository;

	private Baralho baralho;
	private BaralhoEntity baralhoEntity;

	@BeforeEach
	public void setup() {
		baralho = new Baralho();
		baralhoEntity = new BaralhoEntity();
	}

	@DisplayName("realiza o cadastro de um baralho com seu nome usando mock, com sucesso")
	@Test
	void deve_cadastrar_um_baralho_com_sucesso() {
		baralho.setNome("Meu baralho");
		baralhoEntity.setId(1L);
		baralhoEntity.setNome(baralho.getNome());

		when(mkSpringCadastroDeBaralhoRepository.save(any(BaralhoEntity.class))).thenReturn(baralhoEntity);

		Baralho repositoryResponse = repository.save(baralho);

		assertEquals(repositoryResponse.getId(), baralhoEntity.getId());
		assertEquals(repositoryResponse.getNome(), baralho.getNome());

		verify(mkSpringCadastroDeBaralhoRepository).save(any(BaralhoEntity.class));
	}

}
