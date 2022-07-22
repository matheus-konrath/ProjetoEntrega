package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.mapper.OcorrenciaMapper;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.service.BuscaEntregaService;
import com.algaworks.algalog.domain.service.OcorrenciaService;
import com.algaworks.algalog.dto.OcorrenciaDto;
import com.algaworks.algalog.dto.input.OcorrenciaInput;


@RestController
@RequestMapping("/entregas/{id}/ocorrencias")
public class OcorrenciaController {

	@Autowired
	private OcorrenciaService ocorrenciaService;
	@Autowired
	private OcorrenciaMapper ocorrenciaMapper;
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDto resgistrar(@Valid @PathVariable Long id, @RequestBody OcorrenciaInput input) {
		Ocorrencia ocorrencia =  ocorrenciaService.registrar(id, input.getDescricao());
		
		return ocorrenciaMapper.toModel(ocorrencia);
	}
	
	@GetMapping
	public List<OcorrenciaDto> findAll(@PathVariable Long id) {
		Entrega entrega = buscaEntregaService.buscar(id);
		
		return ocorrenciaMapper.toCollectionList(entrega.getOcorrencia());
	}
	
}
