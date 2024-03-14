package br.com.example.apiflashcards.domain.service;

import java.util.ArrayList;
import java.util.List;

import br.com.example.apiflashcards.adapter.in.model.dto.ConsultaDeBaralhosDTO;
import br.com.example.apiflashcards.adapter.in.model.dto.InformacoesParaConsultaDeBaralhoDTO;
import br.com.example.apiflashcards.adapter.out.entity.BaralhoEntity;
import br.com.example.apiflashcards.domain.ports.in.BuscaDeBaralhosServicePorta;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeBaralhosRepositoryPorta;

public class BuscaDeBaralhosServiceImpl implements BuscaDeBaralhosServicePorta {
	private final BuscaDeBaralhosRepositoryPorta buscaDeBaralhosRepositoryPorta;

	public BuscaDeBaralhosServiceImpl(BuscaDeBaralhosRepositoryPorta buscaDeBaralhosRepositoryPorta) {
		this.buscaDeBaralhosRepositoryPorta = buscaDeBaralhosRepositoryPorta;
	}

	@Override
	public ConsultaDeBaralhosDTO consultarInformacoes() {
		List<BaralhoEntity> listaBaralhos = buscaDeBaralhosRepositoryPorta.buscarBaralhos();
		List<InformacoesParaConsultaDeBaralhoDTO> listaInformacoesParaConsultaDeBaralhos = new ArrayList<>();
		listaBaralhos.forEach(baralho -> {
			listaInformacoesParaConsultaDeBaralhos
					.add(new InformacoesParaConsultaDeBaralhoDTO(baralho.getNome(), baralho.getCartas().size()));
		});
		ConsultaDeBaralhosDTO consultaDeBaralhosDTO = new ConsultaDeBaralhosDTO(listaInformacoesParaConsultaDeBaralhos);
		return consultaDeBaralhosDTO;
	}

}
