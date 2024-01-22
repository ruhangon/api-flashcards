package br.com.example.apiflashcards.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.example.apiflashcards.domain.ports.in.AtualizacaoDeCartaServicePorta;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeBaralhoServicePorta;
import br.com.example.apiflashcards.domain.ports.in.CadastroDeCartaServicePorta;
import br.com.example.apiflashcards.domain.ports.out.AtualizacaoDeCartaRepositoryPorta;
import br.com.example.apiflashcards.domain.ports.out.BuscaDeCartaRepositoryPorta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeBaralhoRepositoryPorta;
import br.com.example.apiflashcards.domain.ports.out.CadastroDeCartaRepositoryPorta;
import br.com.example.apiflashcards.domain.service.AtualizacaoDeCartaServiceImpl;
import br.com.example.apiflashcards.domain.service.CadastroDeBaralhoServiceImpl;
import br.com.example.apiflashcards.domain.service.CadastroDeCartaServiceImpl;

@Configuration
public class BeanConfiguration {

	@Bean
	CadastroDeBaralhoServicePorta cadastroDeBaralhoService(
			CadastroDeBaralhoRepositoryPorta cadastroDeBaralhoRepositoryPorta,
			CadastroDeCartaServicePorta cadastroDeCartaServicePorta) {
		return new CadastroDeBaralhoServiceImpl(cadastroDeBaralhoRepositoryPorta, cadastroDeCartaServicePorta);
	}

	@Bean
	CadastroDeCartaServicePorta cadastroDeCartaService(CadastroDeCartaRepositoryPorta cadastroDeCartaRepositoryPorta) {
		return new CadastroDeCartaServiceImpl(cadastroDeCartaRepositoryPorta);
	}

	@Bean
	AtualizacaoDeCartaServicePorta atualizacaoDeCartaService(
			AtualizacaoDeCartaRepositoryPorta atualizacaoDeCartaRepositoryPorta,
			BuscaDeCartaRepositoryPorta buscaDeCartaRepositoryPorta) {
		return new AtualizacaoDeCartaServiceImpl(atualizacaoDeCartaRepositoryPorta, buscaDeCartaRepositoryPorta);
	}

}
