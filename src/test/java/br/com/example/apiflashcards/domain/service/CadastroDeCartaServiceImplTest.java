package br.com.example.apiflashcards.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.adapter.in.model.request.TextoCartaRequestDTO;
import br.com.example.apiflashcards.domain.classes.out.FakeCadastroDeCartaRepositoryImpl;

public class CadastroDeCartaServiceImplTest {
	private FakeCadastroDeCartaRepositoryImpl cadastroDeCartaRepository;

	private static final Long ID_BARALHO = 1L;
	private List<TextoCartaRequestDTO> listaCartas;

	@BeforeEach
	public void setup() {
		cadastroDeCartaRepository = new FakeCadastroDeCartaRepositoryImpl();
	}

	@Test
	void deve_cadastrar_lista_de_cartas_em_um_baralho_com_sucesso() {
		listaCartas = criarListaDeCartas();

		CadastroDeCartaServiceImpl cadastroDeCartaServiceImpl = new CadastroDeCartaServiceImpl(
				cadastroDeCartaRepository);

		String serviceResponse = cadastroDeCartaServiceImpl.cadastrarCartas(listaCartas, ID_BARALHO);

		assertEquals(serviceResponse, HttpStatus.CREATED.getReasonPhrase());
	}

	private List<TextoCartaRequestDTO> criarListaDeCartas() {
		List<TextoCartaRequestDTO> listaCartas = new ArrayList<>();
		TextoCartaRequestDTO carta1 = new TextoCartaRequestDTO();
		carta1.setFrente("info para frente 1");
		carta1.setTras("info para tras 1");
		listaCartas.add(carta1);
		TextoCartaRequestDTO carta2 = new TextoCartaRequestDTO();
		carta2.setFrente("info para frente 2");
		carta2.setTras("info para tras 2");
		listaCartas.add(carta2);
		return listaCartas;
	}

}
