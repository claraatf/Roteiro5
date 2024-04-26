package com.projeto.eda.tad.listasEncadeadas;

public class ListaDuplamenteEncadeadaImpl<E extends Comparable<E>> implements ListaDuplamenteEncadeadaIF<E> {
	public static class Nodo<E> {
		E elemento;
		Nodo<E> anterior;
		Nodo<E> proximo;

		Nodo(E elemento) {
			this.elemento = elemento;
			this.anterior = null;
			this.proximo = null;
		}
	}

	private Nodo<E> cabeca, cauda;
	private int tamanho;

	public ListaDuplamenteEncadeadaImpl() {
		cabeca = cauda = null;
		tamanho = 0;
	}

	public boolean isEmpty() {
		return tamanho == 0;
	}

	public int size() {
		return tamanho;
	}

	@Override
	public NodoListaDuplamenteEncadeada<E> search(E chave) {
		Nodo<E> current = cabeca;
		while (current != null && !current.elemento.equals(chave)) {
			current = current.proximo;
		}
		if (current == null) return null;
		// Assumindo que NodoListaDuplamenteEncadeada tem um construtor que aceita Nodo<E>
		return new NodoListaDuplamenteEncadeada<>(current.elemento, current.anterior, current.proximo);
	}

	public void insert(E elemento) {
		inserePrimeiro(elemento);
	}

	public void insert(E elemento, int index) {
		// Simple implementation for example purposes
		if (index == 0) {
			inserePrimeiro(elemento);
		} else {
			Nodo<E> current = cabeca;
			for (int i = 1; i < index && current != null; i++) {
				current = current.proximo;
			}
			if (current != null) {
				Nodo<E> novoNodo = new Nodo<>(elemento);
				novoNodo.proximo = current.proximo;
				novoNodo.anterior = current;
				if (current.proximo != null) {
					current.proximo.anterior = novoNodo;
				}
				current.proximo = novoNodo;
				if (novoNodo.proximo == null) {
					cauda = novoNodo;
				}
				tamanho++;
			}
		}
	}

	public NodoListaEncadeada<E> remove(E chave) {
		// Simplified removal logic
		Nodo<E> current = cabeca;
		while (current != null && !current.elemento.equals(chave)) {
			current = current.proximo;
		}
		if (current == null) return null;

		if (current.anterior != null) {
			current.anterior.proximo = current.proximo;
		} else {
			cabeca = current.proximo;
		}

		if (current.proximo != null) {
			current.proximo.anterior = current.anterior;
		} else {
			cauda = current.anterior;
		}
		tamanho--;
		return new NodoListaEncadeada<>(current.elemento); // Assumed NodoListaEncadeada is similar to Nodo
	}

	@Override
	public String imprimeEmOrdem() {
		return "";
	}

	@Override
	public String imprimeInverso() {
		return "";
	}

	@Override
	public NodoListaEncadeada<E> sucessor(E chave) {
		return null;
	}

	@Override
	public NodoListaEncadeada<E> predecessor(E chave) {
		return null;
	}

	@Override
	public E[] toArray(Class<E> clazz) {
		return null;
	}

	public void inserePrimeiro(E elemento) {
		Nodo<E> novoNodo = new Nodo<>(elemento);
		if (cabeca == null) {
			cabeca = cauda = novoNodo;
		} else {
			novoNodo.proximo = cabeca;
			cabeca.anterior = novoNodo;
			cabeca = novoNodo;
		}
		tamanho++;
	}

	public NodoListaDuplamenteEncadeada<E> removeUltimo() {
		if (cauda == null) return null;
		Nodo<E> temp = cauda;
		cauda = cauda.anterior;
		if (cauda != null) {
			cauda.proximo = null;
		} else {
			cabeca = null;
		}
		tamanho--;
		return new NodoListaDuplamenteEncadeada<>(temp.elemento); // Assumed NodoListaDuplamenteEncadeada is similar to Nodo
	}

	public NodoListaDuplamenteEncadeada<E> removePrimeiro() {
		if (cabeca == null) return null;
		Nodo<E> temp = cabeca;
		cabeca = cabeca.proximo;
		if (cabeca != null) {
			cabeca.anterior = null;
		} else {
			cauda = null;
		}
		tamanho--;
		return new NodoListaDuplamenteEncadeada<>(temp.elemento); // Assumed NodoListaDuplamenteEncadeada is similar to Nodo
	}

	// Implement other required methods...
}
