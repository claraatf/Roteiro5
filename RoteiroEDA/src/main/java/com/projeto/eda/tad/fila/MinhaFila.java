package com.projeto.eda.tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 * @author fabioleite
 *
 */

public class MinhaFila<E> implements FilaIF<E> {
	private E[] fila;
	private int frente;
	private int tras;
	private int capacidade;

	// Construtor sem parâmetros com capacidade padrão
	public MinhaFila() {
		this(10); // Define um tamanho padrão, como 10
	}

	// Construtor com parâmetro de capacidade
	public MinhaFila(int capacidade) {
		this.capacidade = capacidade;
		fila = (E[]) new Object[capacidade];
		frente = 0;
		tras = -1;
	}

	public MinhaFila(E capacidade) {
	}

	@Override
	public void enfileirar(E item) throws FilaCheiaException {
		if (isFull()) {
			throw new FilaCheiaException();
		}
		tras = (tras + 1) % capacidade;
		fila[tras] = item;
	}

	@Override
	public E desenfileirar() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException();
		}
		E item = fila[frente];
		frente = (frente + 1) % capacidade;
		return item;
	}

	@Override
	public E verificarCauda() {
		if (isEmpty()) {
			return null;
		}
		return fila[tras];
	}

	@Override
	public E verificarCabeca() {
		if (isEmpty()) {
			return null;
		}
		return fila[frente];
	}

	@Override
	public boolean isEmpty() {
		return frente == (tras + 1) % capacidade;
	}

	@Override
	public boolean isFull() {
		return frente == (tras + 2) % capacidade;
	}
}
