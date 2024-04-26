package com.projeto.eda.tad.pilha;

public class MinhaPilha<E> implements PilhaIF<E> {
	private E[] pilha;
	private int topo;
	private int capacidade;

	// Construtor sem parâmetros que define uma capacidade padrão
	public MinhaPilha() {
		this(10);  // Define a capacidade padrão como 10
	}

	// Construtor com parâmetro de capacidade
	public MinhaPilha(int capacidade) {
		this.capacidade = capacidade;
		pilha = (E[]) new Object[capacidade];
		topo = -1;
	}

	// Implementação dos métodos da interface PilhaIF
	@Override
	public void empilhar(E item) throws PilhaCheiaException {
		if (isFull()) {
			throw new PilhaCheiaException("Pilha está cheia");
		}
		pilha[++topo] = item;
	}

	@Override
	public E desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException("Pilha está vazia");
		}
		E item = pilha[topo];
		pilha[topo--] = null; // Prevenir memory leak
		return item;
	}

	@Override
	public E topo() {
		if (isEmpty()) {
			return null;
		}
		return pilha[topo];
	}

	@Override
	public PilhaIF<E> multitop(int k) {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return topo == -1;
	}

	public boolean isFull() {
		return topo == capacidade - 1;
	}
}
