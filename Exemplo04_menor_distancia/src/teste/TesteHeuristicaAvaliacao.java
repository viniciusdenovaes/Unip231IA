package teste;

import dao.InputInstance;
import entity.EspacoEstados;
import entity.estruturas.FilaDePrioridade;
import global.Global;
import solver.heuristica_avaliacao.HeuristicaAvaliacaoG;

public class TesteHeuristicaAvaliacao {
	
	public static void main(String[] args) {
		Global.grafo = InputInstance.getInstance("files/mapa.in");
		EspacoEstados ee = new EspacoEstados(new FilaDePrioridade(new HeuristicaAvaliacaoG()));
		ee.solve();
	}

}
