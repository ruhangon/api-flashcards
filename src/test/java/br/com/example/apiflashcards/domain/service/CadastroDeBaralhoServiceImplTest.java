package br.com.example.apiflashcards.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoComCartasRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.InformacoesParaCadastroDeBaralhoRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaRequestDTO;
import br.com.example.apiflashcards.domain.model.Baralho;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeCartaServicePorta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeBaralhoRepositoryPorta;

@ExtendWith(MockitoExtension.class)
@Tag("unit-test")
public class CadastroDeBaralhoServiceImplTest {
	@Mock
	private CadastroDeBaralhoRepositoryPorta mkCadastroDeBaralhoRepositoryPorta;

	@Mock
	private CadastroDeCartaServicePorta mkCadastroDeCartaServicePorta;

	@InjectMocks
	private CadastroDeBaralhoServiceImpl service;

	private static final Long ID_BARALHO = 1L;
	private static final String NOME_BARALHO = "Meu baralho";

	private CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO;

	@BeforeEach
	public void setup() {
		cadastroDeBaralhoDTO = new CadastroDeBaralhoComCartasRequestDTO();
	}

	@DisplayName("realiza o cadastro de um baralho com duas cartas usando mocks, com sucesso")
	@Test
	void deve_testar_cadastro_de_baralho_com_cartas_com_sucesso() {
		InformacoesParaCadastroDeBaralhoRequestDTO baralhoDTO = new InformacoesParaCadastroDeBaralhoRequestDTO();
		baralhoDTO.setNome(NOME_BARALHO);
		baralhoDTO.setCartas(criarListaDeCartas());
		cadastroDeBaralhoDTO.setBaralho(baralhoDTO);

		Baralho baralho = new Baralho(cadastroDeBaralhoDTO);
		baralho.setId(ID_BARALHO);

		when(mkCadastroDeBaralhoRepositoryPorta.save(any(Baralho.class))).thenReturn(baralho);
		when(mkCadastroDeCartaServicePorta.cadastrarCartas(eq(cadastroDeBaralhoDTO.getBaralho().getCartas()),
				eq(ID_BARALHO))).thenReturn(HttpStatus.CREATED.getReasonPhrase());

		String serviceResponse = service.cadastrarBaralhoComCartas(cadastroDeBaralhoDTO);

		assertEquals(serviceResponse, HttpStatus.CREATED.getReasonPhrase());

		verify(mkCadastroDeBaralhoRepositoryPorta).save(any(Baralho.class));
		verify(mkCadastroDeCartaServicePorta).cadastrarCartas(eq(cadastroDeBaralhoDTO.getBaralho().getCartas()),
				eq(ID_BARALHO));
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
