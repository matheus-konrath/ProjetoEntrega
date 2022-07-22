package com.algaworks.algalog.api.Exceptionhandler;

public class EntityNotFoundException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String msg) {
		super(msg);
	}

}
