package solver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import entity.grafo.Aresta;
import entity.grafo.Caminho;
import entity.grafo.Grafo;
import entity.grafo.ParArestaVertice;
import entity.grafo.Vertice;

public class Estado {
	
	Caminho caminho;
	Grafo grafo;
	
	public Estado(Grafo g, Caminho aCaminho) {
		this.grafo = g;
		this.caminho = aCaminho;
	}
	
	public boolean isValido() {
		boolean res = true;
		
		Set<Aresta> arestas = new TreeSet<>();
		for(ParArestaVertice par: this.caminho.paresArestaVertice) {
			Aresta a = par.a;
			if(arestas.contains(a)) {
				return false;
			}
			arestas.add(a);
		}
		
		return res;
	}
	
	public boolean isObjetivo() {
		Collection<Aresta> todasArestas = grafo.getTodosArestas();
		for(Aresta a: todasArestas) {
			if(! caminho.containsAresta(a)) {
				return false;
			}
		}
		return true;
	}
	
	public Collection<Estado> geraFilhos(){
		Collection<Estado> filhos = new ArrayList<>();
		
		Caminho caminho = this.caminho;
		Vertice ultimoVertice = caminho.ultimoVertice();
		List<Aresta> arestasAdjacentes = grafo.getArestasAdjacentes(ultimoVertice);
		for(Aresta a: arestasAdjacentes) {
			if(caminho.containsAresta(a)) continue;
			Estado filho = new Estado(grafo, this.caminho.deepCopy());
			Vertice v = a.getVerticeAdjacenteQueNao(this.caminho.ultimoVertice());
			filho.caminho.addPar(new ParArestaVertice(a, v));
			filhos.add(filho);
		}
		
		
		return filhos;
	}
	
	public Estado deepCopy() {
		Estado novoEstado = new Estado(this.grafo, this.caminho.deepCopy());
		return novoEstado;
	}
	
	@Override
	public String toString() {
		String res = "";
		res += this.caminho;
		return res;
	}

}
