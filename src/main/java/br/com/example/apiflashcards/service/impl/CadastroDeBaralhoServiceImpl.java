package br.com.example.apiflashcards.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.example.apiflashcards.mapper.BaralhoMapper;
import br.com.example.apiflashcards.model.Baralho;
import br.com.example.apiflashcards.model.dto.CadastroDeBaralhoDTO;
import br.com.example.apiflashcards.repository.BaralhoRepository;
import br.com.example.apiflashcards.service.CadastroDeBaralhoService;

@Service
public class CadastroDeBaralhoServiceImpl implements CadastroDeBaralhoService {
	private final BaralhoRepository baralhoRepository;

	@Autowired
	public CadastroDeBaralhoServiceImpl(BaralhoRepository baralhoRepository) {
		this.baralhoRepository = baralhoRepository;
	}

	@Override
	@Transactional
	public String cadastrarBaralho(CadastroDeBaralhoDTO cadastroDeBaralhoDTO) {
		BaralhoMapper baralhoMapper = new BaralhoMapper();
		Baralho baralho = baralhoMapper.toBaralho(cadastroDeBaralhoDTO);
		baralhoRepository.save(baralho);
		return HttpStatus.CREATED.getReasonPhrase();
	}

}
