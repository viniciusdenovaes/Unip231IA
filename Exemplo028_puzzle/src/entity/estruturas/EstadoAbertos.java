package entity.estruturas;

import solver.Estado;

public interface EstadoAbertos {
	
	public void push(Estado estado);
	public Estado pop();
	public int size();

}
