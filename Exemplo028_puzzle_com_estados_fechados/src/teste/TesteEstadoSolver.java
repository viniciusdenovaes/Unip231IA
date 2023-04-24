package teste;

import java.util.Collection;

import dao.InputInstance;
import entity.Tabuleiro;
import entity.estruturas.Fila;
import entity.estruturas.Pilha;
import solver.EspacoDeEstados;
import solver.Estado;

public class TesteEstadoSolver {
	
	public static void main(String[] args) {
		Tabuleiro t = InputInstance.getInstance("files/inst02.in");
		Estado e = new Estado(t);
		System.out.println("Começando com o estado ");
		System.out.println(e);
		
		EspacoDeEstados ee = new EspacoDeEstados(e, new Pilha());
		Estado solucao = ee.solve();
		System.out.println(e);
		
		
		
	}

}
