package br.com.example.apiflashcards.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.adapter.out.repository.BuscaDeBaralhoRepository;
import br.com.example.apiflashcards.adapter.out.repository.CadastroDeBaralhoRepository;
import br.com.example.apiflashcards.domain.model.Baralho;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Tag("integration-test")
public class CadastroDeBaralhoIT extends IntegrationTestBase {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private BuscaDeBaralhoRepository buscaDeBaralhoRepository;

	@Autowired
	private CadastroDeBaralhoRepository cadastroDeBaralhoRepository;

	private CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO;

	@BeforeEach
	public void setup() {
		cadastroDeBaralhoDTO = criarBaralhoComCartas();
	}

	@DisplayName("realiza teste integrado para validar se cadastro de baralho com cartas no banco de dados funciona")
	@Test
	void deve_cadastrar_um_baralho_com_duas_cartas_com_sucesso() throws Exception {
		mockMvc.perform(post("/baralho/cadastrar").contentType("application/json")
				.content(objectMapper.writeValueAsString(cadastroDeBaralhoDTO))).andExpect(status().isCreated());
	}

	@DisplayName("realiza teste integrado para validar se repository de cadastro de baralho cria baralho com sucesso")
	@Test
	void deve_cadastrar_baralho_com_repository_com_sucesso() {
		Baralho baralho = new Baralho(cadastroDeBaralhoDTO);
		Baralho cadastroRepositoryResponse = cadastroDeBaralhoRepository.save(baralho);

		assertNotNull(cadastroRepositoryResponse.getId());
		assertEquals(cadastroRepositoryResponse.getNome(), baralho.getNome());

		BaralhoEntity baralhoCriado = buscaDeBaralhoRepository.getById(cadastroRepositoryResponse.getId());
		assertNotNull(baralhoCriado.getId());
		assertEquals(baralhoCriado.getNome(), baralho.getNome());
	}

}
