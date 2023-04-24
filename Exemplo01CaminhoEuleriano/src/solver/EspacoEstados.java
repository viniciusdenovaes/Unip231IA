package solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import entity.estruturas.EstadoAbertos;
import entity.estruturas.Fila;
import entity.estruturas.Pilha;
import entity.grafo.Caminho;
import entity.grafo.Grafo;
import entity.grafo.Vertice;

public class EspacoEstados {
	
	Grafo grafo;
	
	List<Estado> estadosIniciais;
	
	EstadoAbertos estadosAbertos;
	
	public EspacoEstados(Grafo g, EstadoAbertos estadosAbertos) {
		this.grafo = g;
		this.estadosAbertos = estadosAbertos;
		
		estadosIniciais = new ArrayList<>();
		for(Vertice v: g.getTodosVertices()) {
			Caminho c = new Caminho(v);
			Estado estadoInicial = new Estado(g, c);
			estadosIniciais.add(estadoInicial);
		}
		
		for(Estado e: estadosIniciais) {
			estadosAbertos.push(e);
		}
	}
	
	public Estado solve() {
		while(estadosAbertos.size()>0) {
			Estado estado = estadosAbertos.pop();
//			System.out.println("tentando resolver");
			System.out.println(estado);
			System.out.println("Tamanho estados abertos: " + estadosAbertos.size());
			System.out.println();
			if(estado.isObjetivo()) {
				System.out.println("Solucao encontrada");
				return estado;
			}
			for(Estado e: estado.geraFilhos()) {
				estadosAbertos.push(e);
			}
		}
		System.out.println("Nao encontramos solucao!!");
		return null;
	}
	
	

}
