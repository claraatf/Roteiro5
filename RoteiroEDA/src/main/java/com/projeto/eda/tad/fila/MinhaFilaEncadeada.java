package com.projeto.eda.tad.fila;

public class MinhaFilaEncadeada<E> implements FilaIF<E> {
	private static class Nodo<E> {
		E elemento;
		Nodo<E> proximo;

		public Nodo(E elemento) {
			this.elemento = elemento;
		}
	}

	private Nodo<E> cabeca, cauda;

	public MinhaFilaEncadeada() {
		cabeca = cauda = null;
	}

	@Override
	public void enfileirar(E item) throws FilaCheiaException {
		Nodo<E> novoNodo = new Nodo<>(item);
		if (cauda != null) {
			cauda.proximo = novoNodo;
		}
		cauda = novoNodo;
		if (cabeca == null) {
			cabeca = cauda;
		}
	}

	@Override
	public E desenfileirar() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException();
		}
		E item = cabeca.elemento;
		cabeca = cabeca.proximo;
		if (cabeca == null) {
			cauda = null;
		}
		return item;
	}

	@Override
	public E verificarCauda() {
		return cauda == null ? null : cauda.elemento;
	}

	@Override
	public E verificarCabeca() {
		return cabeca == null ? null : cabeca.elemento;
	}

	@Override
	public boolean isEmpty() {
		return cabeca == null;
	}

	@Override
	public boolean isFull() {
		// Não aplicável para filas baseadas em lista encadeada.
		return false;
	}
}
