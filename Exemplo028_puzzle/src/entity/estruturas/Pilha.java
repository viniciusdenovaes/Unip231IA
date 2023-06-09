package entity.estruturas;

import java.util.Stack;

import solver.Estado;

public class Pilha implements EstadoAbertos{
	
	private Stack<Estado> elementos = new Stack<>();

	@Override
	public void push(Estado estado) {
		this.elementos.push(estado);
	}

	@Override
	public Estado pop() {
		return this.elementos.pop();
	}

	@Override
	public int size() {
		return this.elementos.size();
	}
	
	

}
