package br.com.example.apiflashcards.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.InformacoesParaCadastroDeBaralhoDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaDTO;
import br.com.example.apiflashcards.domain.classes.in.FakeCadastroDeCartaServiceImpl;
import br.com.example.apiflashcards.domain.classes.out.FakeCadastroDeBaralhoRepositoryImpl;

public class CadastroDeBaralhoServiceImplTest {
	private FakeCadastroDeBaralhoRepositoryImpl cadastroDeBaralhoRepository;
	private FakeCadastroDeCartaServiceImpl cadastroDeCartaService;

	private CadastroDeBaralhoDTO cadastroDeBaralhoDTO;

	@BeforeEach
	public void setup() {
		cadastroDeBaralhoRepository = new FakeCadastroDeBaralhoRepositoryImpl();
		cadastroDeCartaService = new FakeCadastroDeCartaServiceImpl();
		cadastroDeBaralhoDTO = new CadastroDeBaralhoDTO();
	}

	@Test
	void deve_testar_cadastro_de_um_baralho_com_sucesso() {
		InformacoesParaCadastroDeBaralhoDTO baralhoDTO = new InformacoesParaCadastroDeBaralhoDTO();
		baralhoDTO.setNome("Meu baralho");
		baralhoDTO.setCartas(criarListaDeCartas());
		cadastroDeBaralhoDTO.setBaralho(baralhoDTO);

		CadastroDeBaralhoServiceImpl cadastroDeBaralhoServiceImpl = new CadastroDeBaralhoServiceImpl(
				cadastroDeBaralhoRepository, cadastroDeCartaService);

		String serviceResponse = cadastroDeBaralhoServiceImpl.cadastrarBaralho(cadastroDeBaralhoDTO);

		assertEquals(serviceResponse, HttpStatus.CREATED.getReasonPhrase());
	}

	private List<TextoCartaDTO> criarListaDeCartas() {
		List<TextoCartaDTO> listaCartas = new ArrayList<>();
		TextoCartaDTO carta1 = new TextoCartaDTO();
		carta1.setFrente("info para frente 1");
		carta1.setTras("info para tras 1");
		listaCartas.add(carta1);
		TextoCartaDTO carta2 = new TextoCartaDTO();
		carta2.setFrente("info para frente 2");
		carta2.setTras("info para tras 2");
		listaCartas.add(carta2);
		return listaCartas;
	}

}
