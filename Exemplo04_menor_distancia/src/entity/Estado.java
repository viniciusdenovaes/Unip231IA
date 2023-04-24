package entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.grafo.Aresta;
import entity.grafo.Grafo;
import entity.grafo.Vertice;
import global.Global;

public class Estado {
	
	Vertice vertice;
	List<Vertice> caminho;
	
	public Estado(Vertice v) {
		this.vertice = v;
		caminho = new ArrayList<>();
		caminho.add(vertice);
	}
	
	public Estado(Vertice v, List<Vertice> aCaminho) {
		this.vertice = v;
		caminho = aCaminho;
	}
	
	public Vertice getV() {
		return vertice;
	}

	public List<Vertice> getCaminho() {
		return caminho;
	}
	
	public double getCusto() {
		double custo = 0;
		Vertice anterior = caminho.get(0);
		for(int i=1; i<caminho.size(); i++) {
			Vertice atual = caminho.get(i);
			Aresta a = Global.grafo.getAresta(anterior, atual);
			custo += a.getPeso();
			anterior = atual;
		}
		return custo;
	}
	
	public boolean isObjetivo() {
		if(this.vertice.equals(EspacoEstados.estadoObjetivo.vertice)) return true;
		return false;
		
	}
	
	public boolean contains(Vertice v) {
		return this.caminho.contains(v);
	}
	
	public List<Estado> geraFilhos(){
		
		List<Estado> filhos = new LinkedList<>();
		List<Vertice> adjacentes = Global.grafo.getVerticesAdjacentes(vertice);
		for(Vertice v: adjacentes) {
			if(contains(v)) continue;
			Estado filho = this.deepCopy();
			filho.vertice = v;
			filho.caminho.add(v);
			
			filhos.add(filho);
		}
		return filhos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caminho == null) ? 0 : caminho.hashCode());
		result = prime * result + ((vertice == null) ? 0 : vertice.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (caminho == null) {
			if (other.caminho != null)
				return false;
		} else if (!caminho.equals(other.caminho))
			return false;
		if (vertice == null) {
			if (other.vertice != null)
				return false;
		} else if (!vertice.equals(other.vertice))
			return false;
		return true;
	}
	
	public Estado deepCopy() {
		return new Estado(this.vertice, new ArrayList<>(this.caminho));
	}



	@Override
	public String toString() {
		return "Estado [v=" + vertice + ", caminho=" + caminho + "] ("+getCusto()+")" ;
	}
	
	

}
