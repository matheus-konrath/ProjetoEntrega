package com.algaworks.algalog.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.api.Exceptionhandler.EntityNotFoundException;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long id) {
		return entregaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entrega not found"));

	}
}
