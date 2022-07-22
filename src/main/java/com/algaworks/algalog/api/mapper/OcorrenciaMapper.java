package com.algaworks.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.dto.OcorrenciaDto;
import com.algaworks.algalog.dto.input.OcorrenciaInput;

@Component
public class OcorrenciaMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	public OcorrenciaDto toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDto.class);
	}

	public Ocorrencia toEntity(OcorrenciaInput ocorrenciaInput) {
		return modelMapper.map(ocorrenciaInput, Ocorrencia.class);
	}

	public List<OcorrenciaDto> toCollectionList(List<Ocorrencia> ocorrencia) {
		return ocorrencia.stream().map(this::toModel).collect(Collectors.toList());
	}

}