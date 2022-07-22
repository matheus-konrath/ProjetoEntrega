package com.algaworks.algalog.dto;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class OcorrenciaDto {

	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
}
