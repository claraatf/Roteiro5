package com.projeto.eda.tad.pilha;

public class PilhaCheiaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PilhaCheiaException() {
		super("pilha cheia!");
	}

	public PilhaCheiaException(String pilhaEstáCheia) {

	}
}
