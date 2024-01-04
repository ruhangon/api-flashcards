package br.com.example.apiflashcards.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.adapter.in.model.request.CadastroDeBaralhoComCartasRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.request.InformacoesParaCadastroDeBaralhoRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.request.TextoCartaRequestDTO;
import br.com.example.apiflashcards.domain.classes.in.FakeCadastroDeCartaServiceImpl;
import br.com.example.apiflashcards.domain.classes.out.FakeCadastroDeBaralhoRepositoryImpl;

public class CadastroDeBaralhoServiceImplTest {
	private FakeCadastroDeBaralhoRepositoryImpl cadastroDeBaralhoRepository;
	private FakeCadastroDeCartaServiceImpl cadastroDeCartaService;

	private CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO;

	@BeforeEach
	public void setup() {
		cadastroDeBaralhoRepository = new FakeCadastroDeBaralhoRepositoryImpl();
		cadastroDeCartaService = new FakeCadastroDeCartaServiceImpl();
		cadastroDeBaralhoDTO = new CadastroDeBaralhoComCartasRequestDTO();
	}

	@Test
	void deve_testar_cadastro_de_baralho_com_cartas_com_sucesso() {
		InformacoesParaCadastroDeBaralhoRequestDTO baralhoDTO = new InformacoesParaCadastroDeBaralhoRequestDTO();
		baralhoDTO.setNome("Meu baralho");
		baralhoDTO.setCartas(criarListaDeCartas());
		cadastroDeBaralhoDTO.setBaralho(baralhoDTO);

		CadastroDeBaralhoServiceImpl cadastroDeBaralhoServiceImpl = new CadastroDeBaralhoServiceImpl(
				cadastroDeBaralhoRepository, cadastroDeCartaService);

		String serviceResponse = cadastroDeBaralhoServiceImpl.cadastrarBaralhoComCartas(cadastroDeBaralhoDTO);

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
