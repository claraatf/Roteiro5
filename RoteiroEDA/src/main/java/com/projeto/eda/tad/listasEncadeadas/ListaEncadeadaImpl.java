package com.projeto.eda.tad.listasEncadeadas;

public class ListaEncadeadaImpl<E> {
	private static class Nodo<E> {
		E elemento;
		Nodo<E> proximo;

		Nodo(E elemento) {
			this.elemento = elemento;
			this.proximo = null;
		}
	}

	private Nodo<E> cabeca;
	private int tamanho;

	public ListaEncadeadaImpl() {
		cabeca = null;
		tamanho = 0;
	}

	public void adicionarInicio(E elemento) {
		Nodo<E> novoNodo = new Nodo<>(elemento);
		novoNodo.proximo = cabeca;
		cabeca = novoNodo;
		tamanho++;
	}

	public E removerInicio() {
		if (cabeca == null) return null;
		E elemento = cabeca.elemento;
		cabeca = cabeca.proximo;
		tamanho--;
		return elemento;
	}

	public void adicionarFinal(E elemento) {
		Nodo<E> novoNodo = new Nodo<>(elemento);
		if (cabeca == null) {
			cabeca = novoNodo;
		} else {
			Nodo<E> atual = cabeca;
			while (atual.proximo != null) {
				atual = atual.proximo;
			}
			atual.proximo = novoNodo;
		}
		tamanho++;
	}

	public E removerFinal() {
		if (cabeca == null) return null;
		if (cabeca.proximo == null) {
			E elemento = cabeca.elemento;
			cabeca = null;
			tamanho--;
			return elemento;
		}
		Nodo<E> atual = cabeca;
		while (atual.proximo.proximo != null) {
			atual = atual.proximo;
		}
		E elemento = atual.proximo.elemento;
		atual.proximo = null;
		tamanho--;
		return elemento;
	}

	public int tamanho() {
		return tamanho;
	}
}
