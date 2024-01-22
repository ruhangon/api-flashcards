package br.com.example.apiflashcards.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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

import br.com.example.apiflashcards.adapter.in.model.dto.AtualizacaoDeCartaRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.CadastroDeBaralhoComCartasRequestDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.InformacaoParaAtualizacaoDeCartaRequestDTO;
import br.com.example.apiflashcards.adapter.out.repository.AtualizacaoDeCartaRepository;
import br.com.example.apiflashcards.adapter.out.repository.BuscaDeCartaRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Tag("integration-test")
public class AtualizacaoDeCartaIT extends IntegrationTestBase {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private BuscaDeCartaRepository buscaDeCartaRepository;

	@Autowired
	private AtualizacaoDeCartaRepository atualizacaoDeCartaRepository;

	private CadastroDeBaralhoComCartasRequestDTO cadastroDeBaralhoDTO;
	private AtualizacaoDeCartaRequestDTO atualizacaoDeCartaDTO;

	private static final Long ID_CARTA = 1L;
	private static final Integer INFO_AVALIACAO = 1;

	@BeforeEach
	public void setup() throws Exception {
		cadastroDeBaralhoDTO = criarBaralhoComCartas();
		mockMvc.perform(post("/baralho/cadastrar").contentType("application/json")
				.content(objectMapper.writeValueAsString(cadastroDeBaralhoDTO))).andExpect(status().isCreated());

		atualizacaoDeCartaDTO = new AtualizacaoDeCartaRequestDTO();
		InformacaoParaAtualizacaoDeCartaRequestDTO informacaoParaCartaDTO = new InformacaoParaAtualizacaoDeCartaRequestDTO();
		informacaoParaCartaDTO.setAvaliacao(INFO_AVALIACAO);
		atualizacaoDeCartaDTO.setCarta(informacaoParaCartaDTO);
	}

	@DisplayName("realiza teste integrado para validar se atualização da fila de uma carta no banco de dados funciona")
	@Test
	void deve_atualizar_fila_de_uma_carta_com_sucesso() throws Exception {
		Integer filaAntigaDaCarta = buscaDeCartaRepository.findFila(ID_CARTA);

		mockMvc.perform(patch("/carta/{id-carta}/fila/atualizar", Long.toString(ID_CARTA))
				.contentType("application/json").content(objectMapper.writeValueAsString(atualizacaoDeCartaDTO)))
				.andExpect(status().isOk());

		Integer filaAtualDaCarta = buscaDeCartaRepository.findFila(ID_CARTA);

		assertEquals(filaAtualDaCarta, (filaAntigaDaCarta + INFO_AVALIACAO));
	}

	@DisplayName("realiza teste integrado para validar se repository de atualização de carta atualiza fila com sucesso")
	@Test
	void deve_atualizar_fila_de_uma_carta_com_repository_com_sucesso() {
		Integer filaAntigaDaCarta = buscaDeCartaRepository.findFila(ID_CARTA);
		Integer novaFila = filaAntigaDaCarta + INFO_AVALIACAO;

		atualizacaoDeCartaRepository.updateFila(ID_CARTA, novaFila);

		Integer filaAtualDaCarta = buscaDeCartaRepository.findFila(ID_CARTA);

		assertEquals(filaAtualDaCarta, novaFila);
	}

}
