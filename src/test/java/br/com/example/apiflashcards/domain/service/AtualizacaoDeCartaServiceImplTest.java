package br.com.example.apiflashcards.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.domain.classes.out.FakeAtualizacaoDeCartaRepositoryImpl;
import br.com.example.apiflashcards.domain.classes.out.FakeBuscaDeCartaRepositoryImpl;

@Tag("unit-test")
public class AtualizacaoDeCartaServiceImplTest {
	private FakeAtualizacaoDeCartaRepositoryImpl atualizacaoDeCartaRepository;
	private FakeBuscaDeCartaRepositoryImpl buscaDeCartaRepository;

	private static final Long ID_CARTA = 1L;
	private static final Integer INFO_AVALIACAO = 1;

	@BeforeEach
	public void setup() {
		atualizacaoDeCartaRepository = new FakeAtualizacaoDeCartaRepositoryImpl();
		buscaDeCartaRepository = new FakeBuscaDeCartaRepositoryImpl();
	}

	@DisplayName("realiza a atualização da fila de uma carta usando classes fake, com sucesso")
	@Test
	void deve_atualizar_a_fila_de_uma_carta() {
		AtualizacaoDeCartaServiceImpl atualizacaoDeCartaServiceImpl = new AtualizacaoDeCartaServiceImpl(
				atualizacaoDeCartaRepository, buscaDeCartaRepository);

		String serviceResponse = atualizacaoDeCartaServiceImpl.atualizarFilaDeCarta(ID_CARTA, INFO_AVALIACAO);

		assertEquals(serviceResponse, HttpStatus.OK.getReasonPhrase());

		int novaFilaDaCartaAtual = INFO_AVALIACAO + buscaDeCartaRepository.findFila(ID_CARTA);

		assertEquals(atualizacaoDeCartaRepository.getNovaFilaDaCartaAtual(), novaFilaDaCartaAtual);
	}

}
