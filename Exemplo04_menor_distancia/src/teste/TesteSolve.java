package teste;

import dao.InputInstance;
import entity.EspacoEstados;
import entity.estruturas.Fila;
import entity.estruturas.FilaDePrioridade;
import entity.estruturas.Pilha;
import global.Global;
import solver.heuristica_avaliacao.HeuristicaAvaliacao;
import solver.heuristica_avaliacao.HeuristicaAvaliacaoF;
import solver.heuristica_avaliacao.HeuristicaAvaliacaoG;
import solver.heuristica_avaliacao.HeusiticaAvaliacaoLinhaReta;

public class TesteSolve {
	
	public static void main(String[] args) {
		Global.grafo = InputInstance.getInstance("files/mapa.in");
		HeuristicaAvaliacao heuH = new HeusiticaAvaliacaoLinhaReta(Global.grafo);
		HeuristicaAvaliacaoF heuF = new HeuristicaAvaliacaoF(heuH);
		FilaDePrioridade fila = new FilaDePrioridade(heuF);
		EspacoEstados ee = new EspacoEstados(new Fila());
		ee.solve();
	}

}
