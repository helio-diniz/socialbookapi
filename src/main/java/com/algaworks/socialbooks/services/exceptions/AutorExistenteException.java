package com.algaworks.socialbooks.services.exceptions;

// RuntimeException: exeção checável somente em tempo de execução
public class AutorExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1767749817939741532L;

	public AutorExistenteException(String mensagem){
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
