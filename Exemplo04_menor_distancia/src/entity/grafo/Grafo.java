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
	Map<Vertice, List<Vertice>> listaDeAdjacencia;
	
	public Grafo() {
		V = new TreeMap<>();
		A = new TreeMap<>();
		listaDeAdjacencia = new TreeMap<>();
	}
	
	public void addAresta(Aresta a) {
		addVertice(a.v1);
		addVertice(a.v2);
		A.put(a.id, a);
		listaDeAdjacencia.get(a.v1).add(a.v2);
		listaDeAdjacencia.get(a.v2).add(a.v1);
	}
	
	public void addVertice(Vertice v) {
		V.put(v.id, v);
		if(!listaDeAdjacencia.containsKey(v)) {
			listaDeAdjacencia.put(v, new ArrayList<>());
		}
	}
	
//	public void addAresta(String nomeV1, String nomeV2, double peso) {
//		Aresta a = new Aresta(new Vertice(nomeV1), new Vertice(nomeV2), peso);
//		this.addAresta(a);
//	}
	
	public Vertice getVertice(String nome) {
		return this.V.get(nome);
	}
	
	public Aresta getAresta(Vertice v1, Vertice v2) {
		return this.A.get(Aresta.getIdAresta(v1, v2));
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
	
	public Map<Vertice, List<Vertice>> getListaAdjacencia(){
		return this.listaDeAdjacencia;
	}
	
	public List<Vertice> getVerticesAdjacentes(Vertice v){
		return this.listaDeAdjacencia.get(v);
	}
	
	private String listaAdajacenciaToSring(Vertice vOriginal) {
		String res = "";
		for(Vertice adj: listaDeAdjacencia.get(vOriginal)) {
			res += " " + adj;
		}
		return res;
		
	}
	
	public double getDistanciaEuclidiana(Vertice v1, Vertice v2) {
		double x1 = v1.coordenada.x;
		double y1 = v1.coordenada.y;
		double x2 = v2.coordenada.x;
		double y2 = v2.coordenada.y;
		
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		
	}
	
	public double getDistanciaEuclidiana(String nomeV1, String nomeV2) {
		Vertice v1 = this.getVertice(nomeV1);
		Vertice v2 = this.getVertice(nomeV2);
		return getDistanciaEuclidiana(v1, v2);
	}
	
	@Override
	public String toString() {
		String res = "";
		
		for(Vertice v: this.V.values()) {
			res += v + ", adjs: " + listaAdajacenciaToSring(v) + "\n";
		}
		System.out.println("\nDistancias do mapa (Instancia): \n");
		for(Aresta a: this.A.values()) {
			res += a + "\n";
		}
		
		System.out.println("\n\nDistancias euclidianas: \n");
		for(Vertice v1: this.V.values()) {
			for(Vertice v2: this.V.values()) {
				if(v1.compareTo(v2)<=0) {
					res += v1.id + "-" + v2.id + ": " + getDistanciaEuclidiana(v1, v2) + "\n";
				}
			}
		}
		
		return res;
	}
	

}
