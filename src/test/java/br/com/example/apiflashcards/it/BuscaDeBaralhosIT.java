package br.com.example.apiflashcards.it;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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
import br.com.example.apiflashcards.adapter.out.repository.BuscaDeBaralhosRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Tag("integration-test")
public class BuscaDeBaralhosIT extends IntegrationTestBase {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private BuscaDeBaralhosRepository buscaDeBaralhosRepository;

	private CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO;

	@BeforeEach
	public void setup() throws Exception {
		cadastroDeBaralhoDTO = criarBaralhoComCartas();
		mockMvc.perform(post("/baralho/cadastrar").contentType("application/json")
				.content(objectMapper.writeValueAsString(cadastroDeBaralhoDTO))).andExpect(status().isCreated());
	}

	@DisplayName("realiza teste integrado para validar se consulta de informações de baralhos funciona")
	@Test
	void deve_consultar_informacoes_de_baralhos_com_sucesso() throws Exception {
		mockMvc.perform(get("/baralhos/consultar").contentType("application/json")).andExpect(status().isOk());
	}

	@DisplayName("realiza teste integrado para validar se repository de busca de baralhos consulta informações com sucesso")
	@Test
	void deve_consultar_informacoes_de_baralhos_com_repository_com_sucesso() {
		List<BaralhoEntity> consultaRepositoryResponse = buscaDeBaralhosRepository.buscarBaralhos();

		assertNotNull(consultaRepositoryResponse);
	}

}
