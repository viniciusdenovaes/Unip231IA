package teste;

import dao.InputInstance;
import entity.estruturas.Fila;
import entity.estruturas.Pilha;
import entity.grafo.Grafo;
import solver.EspacoEstados;
import solver.Estado;

public class TesteBuscaEspacoEstados {
	
	public static void main(String[] args) {
		Grafo g = InputInstance.getInstance("files/inst-pontes-konis.in");
		EspacoEstados ee = new EspacoEstados(g, new Pilha());
		Estado solucao = ee.solve();
		
		if(solucao==null) {
			System.out.println("solucao null");
		}else {
			System.out.println("Solucao ");
			System.out.println(solucao);
		}
	}

}
