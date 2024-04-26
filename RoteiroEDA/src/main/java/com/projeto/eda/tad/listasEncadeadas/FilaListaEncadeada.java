package com.projeto.eda.tad.listasEncadeadas;


import com.projeto.eda.tad.fila.FilaCheiaException;
import com.projeto.eda.tad.fila.FilaIF;
import com.projeto.eda.tad.fila.FilaVaziaException;

public class FilaListaEncadeada implements FilaIF<NodoListaEncadeada<Integer>> {
	
	private ListaEncadeadaIF<Integer> fila;

	@Override
	public void enfileirar(NodoListaEncadeada<Integer> item) throws FilaCheiaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NodoListaEncadeada<Integer> desenfileirar() throws FilaVaziaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoListaEncadeada<Integer> verificarCauda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoListaEncadeada<Integer> verificarCabeca() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

}
