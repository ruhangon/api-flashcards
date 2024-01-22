package br.com.example.apiflashcards.domain.ports.out;

public interface AtualizacaoDeCartaRepositoryPorta {
	void updateFila(Long idCarta, Integer novaFila);

}
