package br.com.example.apiflashcards.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoComCartasRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.InformacaoParaCadastroDeCartaRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaRequestDTO;
import br.com.example.apiflashcards.adapter.out.repository.BuscaDeCartaRepository;
import br.com.example.apiflashcards.adapter.out.repository.CadastroDeCartaRepository;
import br.com.example.apiflashcards.domain.model.Carta;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Tag("integration-test")
public class CadastroDeCartaIT extends IntegrationTestBase {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private BuscaDeCartaRepository buscaDeCartaRepository;

	@Autowired
	private CadastroDeCartaRepository cadastroDeCartaRepository;

	private CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO;
	private InformacaoParaCadastroDeCartaRequestDTO informacaoParaCadastroDeCartaDTO;

	private static final Long ID_BARALHO = 1L;

	@BeforeEach
	public void setup() throws Exception {
		cadastroDeBaralhoDTO = criarBaralhoComCartas();
		mockMvc.perform(post("/baralho/cadastrar").contentType("application/json")
				.content(objectMapper.writeValueAsString(cadastroDeBaralhoDTO))).andExpect(status().isCreated());

		informacaoParaCadastroDeCartaDTO = new InformacaoParaCadastroDeCartaRequestDTO();
		TextoCartaRequestDTO carta = new TextoCartaRequestDTO();
		carta.setFrente("info para frente 1");
		carta.setTras("info para tras 1");
		informacaoParaCadastroDeCartaDTO.setCarta(carta);
	}

	@DisplayName("realiza teste integrado para validar se cadastro de uma carta em um baralho no banco de dados funciona")
	@Test
	void deve_cadastrar_uma_carta_em_um_baralho_com_sucesso() throws Exception {
		Long quantidadeAntigaCartasDoBaralho = buscaDeCartaRepository.countCartasBaralho(ID_BARALHO);

		mockMvc.perform(
				post("/baralho/{id-baralho}/carta/cadastrar", Long.toString(ID_BARALHO)).contentType("application/json")
						.content(objectMapper.writeValueAsString(informacaoParaCadastroDeCartaDTO)))
				.andExpect(status().isCreated());

		Long quantidadeNovaCartasDoBaralho = buscaDeCartaRepository.countCartasBaralho(ID_BARALHO);

		assertEquals(quantidadeNovaCartasDoBaralho, (quantidadeAntigaCartasDoBaralho + 1));
	}

	@DisplayName("realiza teste integrado para validar se repository de cadastro de carta cadastra uma carta com sucesso")
	@Test
	void deve_cadastrar_carta_em_um_baralho_com_repository_com_sucesso() {
		Long quantidadeAntigaCartasDoBaralho = buscaDeCartaRepository.countCartasBaralho(ID_BARALHO);

		Carta carta = new Carta();
		carta.setId(1L);
		carta.setFrente("frente");
		carta.setTras("tras");
		carta.setFila(1);
		cadastroDeCartaRepository.save(carta, ID_BARALHO);

		Long quantidadeNovaCartasDoBaralho = buscaDeCartaRepository.countCartasBaralho(ID_BARALHO);

		assertEquals(quantidadeNovaCartasDoBaralho, (quantidadeAntigaCartasDoBaralho + 1));
	}

}
