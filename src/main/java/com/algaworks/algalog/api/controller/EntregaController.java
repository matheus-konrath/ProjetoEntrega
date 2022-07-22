package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.mapper.EntregaMapper;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.service.EntregaService;
import com.algaworks.algalog.domain.service.FinalizacaoService;
import com.algaworks.algalog.dto.EntregaDto;
import com.algaworks.algalog.dto.input.EntregaInput;
import com.algaworks.algalog.repository.EntregaRepository;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaService entregaService;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private EntregaMapper entregaMapper;
	
	@Autowired
	private FinalizacaoService finalizacaoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDto solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaMapper.toEntity(entregaInput);
		Entrega entregaSolicitada =  entregaService.solicitar(novaEntrega);
		return entregaMapper.toModel(entregaSolicitada);		
	}
	
	@GetMapping
	public List<EntregaDto>listar(){
		return entregaMapper.toCollectionModel(entregaRepository.findAll());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaDto> buscar(@PathVariable Long id) {
		return entregaRepository.findById(id)
				.map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long id) {
		finalizacaoService.finalizar(id);
	}
}
