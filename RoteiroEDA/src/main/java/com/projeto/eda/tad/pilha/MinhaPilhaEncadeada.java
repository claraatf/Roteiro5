package com.projeto.eda.tad.pilha;

public class MinhaPilhaEncadeada<E> implements PilhaIF<E> {
	private static class Nodo<E> {
		E elemento;
		Nodo<E> proximo;

		public Nodo(E elemento, Nodo<E> proximo) {
			this.elemento = elemento;
			this.proximo = proximo;
		}
	}

	private Nodo<E> topo;

	public MinhaPilhaEncadeada() {
		topo = null;
	}

	@Override
	public void empilhar(E item) {
		topo = new Nodo<>(item, topo);
	}

	@Override
	public E desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}
		E item = topo.elemento;
		topo = topo.proximo;
		return item;
	}

	@Override
	public E topo() {
		if (isEmpty()) {
			return null;
		}
		return topo.elemento;
	}

	@Override
	public PilhaIF<E> multitop(int k) {
		MinhaPilhaEncadeada<E> novaPilha = new MinhaPilhaEncadeada<>();
		Nodo<E> atual = topo;
		int contagem = 0;
		while (atual != null && contagem < k) {
			novaPilha.empilhar(atual.elemento);
			atual = atual.proximo;
			contagem++;
		}
		return novaPilha;
	}

	@Override
	public boolean isEmpty() {
		return topo == null;
	}

	// A função isFull não é aplicável em pilhas baseadas em listas encadeadas, pois sua capacidade é dinâmica.
}
