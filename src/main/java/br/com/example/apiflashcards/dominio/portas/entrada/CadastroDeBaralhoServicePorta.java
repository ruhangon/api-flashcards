package br.com.example.apiflashcards.dominio.portas.entrada;

import br.com.example.apiflashcards.adaptador.entrada.model.dto.CadastroDeBaralhoDTO;

public interface CadastroDeBaralhoServicePorta {
	String cadastrarBaralho(CadastroDeBaralhoDTO cadastroDeBaralhoDTO);

}
