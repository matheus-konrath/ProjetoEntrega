package com.algaworks.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.dto.EntregaDto;
import com.algaworks.algalog.dto.input.EntregaInput;

@Component
public class EntregaMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public EntregaDto toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDto.class);
	}
	
	public List<EntregaDto> toCollectionModel(List<Entrega> entregas){
		return entregas.stream()
				.map(this::toModel).collect(Collectors.toList());		
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
}
