package entity.grafo;

import java.util.ArrayList;
import java.util.List;

public class Caminho {
	
	public Vertice inicial;
	public List<Vertice> vertices;
	Vertice ultimoVertice; 
	
	public Caminho(Vertice aInicial) {
		this.inicial = aInicial;
		this.ultimoVertice = aInicial;
		this.vertices = new ArrayList<>();
		this.vertices.add(this.inicial);
	}
	
	public void addVertice(Vertice v) {
		vertices.add(v);
		ultimoVertice = v;
	}
	
	public Vertice ultimoVertice() {
		return this.ultimoVertice;
	}
	
//	public boolean containsAresta(Aresta a) {
//		for(ParArestaVertice pav : paresArestaVertice) {
//			if(a.equals(pav.a)) return true;
//		}
//		return false;
//	}
	
	public Caminho deepCopy() {
		Caminho novoCaminho = new Caminho(this.inicial);
		for(Vertice v: this.vertices) {
			novoCaminho.addVertice(v);
		}
		return novoCaminho;
		
	}
	
	@Override
	public String toString() {
		String res = "";
		for(Vertice v: this.vertices) {
			res += v + " ";
		}
		return res;
	}
	

}




