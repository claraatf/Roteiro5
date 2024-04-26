package com.projeto.eda.tad.conjuntoDinamico;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer> {
	private Integer[] elementos;
	private int tamanhoAtual;
	private static final int CAPACIDADE_INICIAL = 10;

	public MeuConjuntoDinamico() {
		this.elementos = new Integer[CAPACIDADE_INICIAL];
		this.tamanhoAtual = 0;
	}

	private void expandirCapacidade() {
		Integer[] novosElementos = new Integer[elementos.length * 2];
		System.arraycopy(elementos, 0, novosElementos, 0, elementos.length);
		elementos = novosElementos;
	}

	@Override
	public void inserir(Integer item) {
		if (tamanhoAtual == elementos.length) {
			expandirCapacidade();
		}
		elementos[tamanhoAtual++] = item;
	}

	@Override
	public Integer remover(Integer item) throws Exception {
		for (int i = 0; i < tamanhoAtual; i++) {
			if (elementos[i].equals(item)) {
				Integer elementoRemovido = elementos[i];
				elementos[i] = elementos[tamanhoAtual - 1];
				elementos[tamanhoAtual - 1] = null;
				tamanhoAtual--;
				return elementoRemovido;
			}
		}
		throw new Exception("Elemento não encontrado");
	}

	@Override
	public Integer buscar(Integer item) {
		for (int i = 0; i < tamanhoAtual; i++) {
			if (elementos[i].equals(item)) {
				return elementos[i];
			}
		}
		return null;
	}

	@Override
	public int tamanho() {
		return tamanhoAtual;
	}

	@Override
	public Integer maximum() {
		if (tamanhoAtual == 0) return null;
		Integer max = elementos[0];
		for (int i = 1; i < tamanhoAtual; i++) {
			if (elementos[i].compareTo(max) > 0) {
				max = elementos[i];
			}
		}
		return max;
	}

	@Override
	public Integer minimum() {
		if (tamanhoAtual == 0) return null;
		Integer min = elementos[0];
		for (int i = 1; i < tamanhoAtual; i++) {
			if (elementos[i].compareTo(min) < 0) {
				min = elementos[i];
			}
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
