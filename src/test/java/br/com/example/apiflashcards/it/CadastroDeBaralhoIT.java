package br.com.example.apiflashcards.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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
import br.com.example.apiflashcards.adapter.in.model.dto.InformacoesParaCadastroDeBaralhoRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.TextoCartaRequestDTO;
import br.com.example.apiflashcards.adapter.out.repository.CadastroDeBaralhoRepository;
import br.com.example.apiflashcards.domain.model.Baralho;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Tag("integration-test")
public class CadastroDeBaralhoIT {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private CadastroDeBaralhoRepository repository;

	private CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO;

	@BeforeEach
	public void setup() {
		cadastroDeBaralhoDTO = new CadastroDeBaralhoComCartasRequestDTO();
		InformacoesParaCadastroDeBaralhoRequestDTO baralhoDTO = new InformacoesParaCadastroDeBaralhoRequestDTO();
		baralhoDTO.setNome("Meu baralho");
		baralhoDTO.setCartas(criarListaDeCartas());
		cadastroDeBaralhoDTO.setBaralho(baralhoDTO);
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
		Baralho repositoryResponse = repository.save(baralho);

		assertNotNull(repositoryResponse.getId());
		assertEquals(repositoryResponse.getNome(), baralho.getNome());
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
