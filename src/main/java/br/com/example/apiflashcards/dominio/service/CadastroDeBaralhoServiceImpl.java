package br.com.example.apiflashcards.dominio.service;

import org.springframework.http.HttpStatus;

import br.com.example.apiflashcards.adaptador.entrada.model.dto.CadastroDeBaralhoDTO;
import br.com.example.apiflashcards.dominio.Baralho;
import br.com.example.apiflashcards.dominio.portas.entrada.CadastroDeBaralhoServicePorta;
import br.com.example.apiflashcards.dominio.portas.entrada.CadastroDeCartaServicePorta;
import br.com.example.apiflashcards.dominio.portas.saida.CadastroDeBaralhoRepositoryPorta;
import br.com.example.apiflashcards.dominio.service.mapper.BaralhoMapper;

public class CadastroDeBaralhoServiceImpl implements CadastroDeBaralhoServicePorta {
	private final CadastroDeBaralhoRepositoryPorta cadastroDeBaralhoRepositoryPorta;
	private final CadastroDeCartaServicePorta cadastroDeCartaServicePorta;

	public CadastroDeBaralhoServiceImpl(CadastroDeBaralhoRepositoryPorta cadastroDeBaralhoRepositoryPorta,
			CadastroDeCartaServicePorta cadastroDeCartaServicePorta) {
		this.cadastroDeBaralhoRepositoryPorta = cadastroDeBaralhoRepositoryPorta;
		this.cadastroDeCartaServicePorta = cadastroDeCartaServicePorta;
	}

	@Override
	public String cadastrarBaralho(CadastroDeBaralhoDTO cadastroDeBaralhoDTO) {
		BaralhoMapper baralhoMapper = new BaralhoMapper();
		Baralho baralho = baralhoMapper.toBaralho(cadastroDeBaralhoDTO);
		cadastroDeBaralhoRepositoryPorta.save(baralho);
		cadastroDeCartaServicePorta.cadastrarCartas(cadastroDeBaralhoDTO.baralho().cartas(), baralho.getId());
		return HttpStatus.CREATED.getReasonPhrase();
	}

}
