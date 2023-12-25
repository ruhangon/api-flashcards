package br.com.example.apiflashcards.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.example.apiflashcards.dominio.portas.entrada.CadastroDeBaralhoServicePorta;
import br.com.example.apiflashcards.dominio.portas.entrada.CadastroDeCartaServicePorta;
import br.com.example.apiflashcards.dominio.portas.saida.CadastroDeBaralhoRepositoryPorta;
import br.com.example.apiflashcards.dominio.portas.saida.CadastroDeCartaRepositoryPorta;
import br.com.example.apiflashcards.dominio.service.CadastroDeBaralhoServiceImpl;
import br.com.example.apiflashcards.dominio.service.CadastroDeCartaServiceImpl;

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

}
