package teste;

import dao.InputInstance;
import entity.Tabuleiro;
import entity.estruturas.Fila;
import entity.estruturas.FilaDePrioridade;
import solver.EspacoDeEstados;
import solver.Estado;
import solver.heuristica_avaliacao.HeuristicaAvaliacaoF;
import solver.heuristica_avaliacao.HeuristicaAvaliacaoPecasForaLugar;

public class TesteEspacoEstadoHeuristicaAvaliacaoF {
	public static void main(String[] args) {
		
		Tabuleiro t = InputInstance.getInstance("files/inst02.in");
		Estado e = new Estado(t);
		System.out.println("Começando com o estado ");
		System.out.println(e);
		
		EspacoDeEstados ee = new EspacoDeEstados(e, 
				new FilaDePrioridade(
						new HeuristicaAvaliacaoF(
								new HeuristicaAvaliacaoPecasForaLugar())));
		Estado solucao = ee.solve();
		System.out.println("SOLUCAO: " + solucao);
		
	}

}
