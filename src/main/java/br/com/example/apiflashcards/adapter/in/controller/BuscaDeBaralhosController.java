package br.com.example.apiflashcards.adapter.in.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.apiflashcards.adapter.in.model.dto.ConsultaDeBaralhosDTO;
import br.com.example.apiflashcards.domain.ports.in.BuscaDeBaralhosServicePorta;

@RestController
@RequestMapping("/baralhos")
public class BuscaDeBaralhosController {
	private final BuscaDeBaralhosServicePorta buscaDeBaralhosServicePorta;

	public BuscaDeBaralhosController(BuscaDeBaralhosServicePorta buscaDeBaralhosServicePorta) {
		this.buscaDeBaralhosServicePorta = buscaDeBaralhosServicePorta;
	}

	@GetMapping(value = "/consultar")
	public ConsultaDeBaralhosDTO consultarInformacoesDeBaralhos() {
		ConsultaDeBaralhosDTO consultaDeBaralhosDTO = buscaDeBaralhosServicePorta.consultarInformacoes();
		return consultaDeBaralhosDTO;
	}

}
