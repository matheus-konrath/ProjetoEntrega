package com.algaworks.algalog.domain.service;


import java.time.OffsetDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;

import com.algaworks.algalog.repository.EntregaRepository;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private CatalagoClienteService catalogoCatalagoClienteService;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoCatalagoClienteService.buscar(entrega.getCliente().getId());	
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		
		return entregaRepository.save(entrega);
	}

}
