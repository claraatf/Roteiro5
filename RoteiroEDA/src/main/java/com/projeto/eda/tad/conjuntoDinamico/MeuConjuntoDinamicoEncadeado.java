package com.projeto.eda.tad.conjuntoDinamico;

public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {
	private class Nodo {
		Integer valor;
		Nodo proximo;

		Nodo(Integer valor) {
			this.valor = valor;
			this.proximo = null;
		}
	}

	private Nodo cabeca;
	private int tamanho;

	public MeuConjuntoDinamicoEncadeado() {
		cabeca = null;
		tamanho = 0;
	}

	@Override
	public void inserir(Integer item) {
		Nodo novoNodo = new Nodo(item);
		novoNodo.proximo = cabeca;
		cabeca = novoNodo;
		tamanho++;
	}

	@Override
	public Integer remover(Integer item) throws Exception {
		Nodo atual = cabeca, anterior = null;
		while (atual != null) {
			if (atual.valor.equals(item)) {
				if (anterior == null) {
					cabeca = atual.proximo;
				} else {
					anterior.proximo = atual.proximo;
				}
				tamanho--;
				return atual.valor;
			}
			anterior = atual;
			atual = atual.proximo;
		}
		throw new Exception("Elemento não encontrado");
	}

	@Override
	public Integer buscar(Integer item) {
		Nodo atual = cabeca;
		while (atual != null) {
			if (atual.valor.equals(item)) {
				return atual.valor;
			}
			atual = atual.proximo;
		}
		return null;
	}

	@Override
	public int tamanho() {
		return tamanho;
	}

	@Override
	public Integer maximum() {
		if (cabeca == null) return null;
		Integer max = cabeca.valor;
		Nodo atual = cabeca.proximo;
		while (atual != null) {
			if (atual.valor.compareTo(max) > 0) {
				max = atual.valor;
			}
			atual = atual.proximo;
		}
		return max;
	}

	@Override
	public Integer minimum() {
		if (cabeca == null) return null;
		Integer min = cabeca.valor;
		Nodo atual = cabeca.proximo;
		while (atual != null) {
			if (atual.valor.compareTo(min) < 0) {
				min = atual.valor;
			}
			atual = atual.proximo;
		}
		return min;
	}

	@Override
	public Integer predecessor(Integer item) {
		// Implementação dependente do cenário
		return null;
	}

	@Override
	public Integer sucessor(Integer item) {
		// Implementação dependente do cenário
		return null;
	}
}
