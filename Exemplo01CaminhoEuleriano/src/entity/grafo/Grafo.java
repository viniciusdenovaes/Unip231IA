package entity.grafo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Grafo {
	
	Map<String, Vertice> V;
	Map<String, Aresta> A;
	Map<Vertice, List<Aresta>> listaDeAdjacencia;
	
	public Grafo() {
		V = new TreeMap<>();
		A = new TreeMap<>();
		listaDeAdjacencia = new TreeMap<>();
	}
	
	public void addVertice(Vertice v) {
		V.put(v.id, v);
		listaDeAdjacencia.put(v, new ArrayList<>());
	}
	
	public void addVertice(String nomeVertice) {
		this.addVertice(new Vertice(nomeVertice));
	}
	
	public void addAresta(Aresta a) {
		A.put(a.id, a);
		listaDeAdjacencia.get(a.v1).add(a);
		listaDeAdjacencia.get(a.v2).add(a);
	}
	
	public void addAresta(String nomeAresta, String nomeV1, String nomeV2) {
		Aresta a = new Aresta(nomeAresta, new Vertice(nomeV1), new Vertice(nomeV2));
		this.addAresta(a);
	}
	
	public Vertice getVertice(String nome) {
		return this.V.get(nome);
	}
	
	public Aresta getAresta(String nome) {
		return this.A.get(nome);
	}
	
	public Collection<Vertice> getTodosVertices(){
		return this.V.values();
	}
	
	public Collection<Aresta> getTodosArestas(){
		return this.A.values();
	} 
	
	public Map<Vertice, List<Aresta>> getListaAdjacencia(){
		return this.listaDeAdjacencia;
	}
	
	public List<Aresta> getArestasAdjacentes(Vertice v){
		return this.listaDeAdjacencia.get(v);
	}
	
	@Override
	public String toString() {
		String res = "";
		
		for(Vertice v: this.V.values()) {
			res += v + "\n";
		}
		for(Aresta a: this.A.values()) {
			res += a + "\n";
		}
		
		return res;
	}
	

}
