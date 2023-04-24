package teste;

import dao.InputInstance;
import entity.Tabuleiro;
import solver.EspacoDeEstados;
import solver.Estado;
import solver.heuristica_avaliacao.HeuristicaAvaliacaoPecasForaLugar;

public class TesteHeuristicaAvaliacao {
	
	public static void main(String[] args) {
		Tabuleiro t1 = InputInstance.getInstance("files/inst01.in");
		Estado e1 = new Estado(t1);
		Tabuleiro t2 = InputInstance.getInstance("files/inst02.in");
		Estado e2 = new Estado(t2);
		Tabuleiro t3 = InputInstance.getInstance("files/inst03.in");
		Estado e3 = new Estado(t3);
		Tabuleiro tO = InputInstance.getInstance("files/inst_obj.in");
		Estado eO = new Estado(tO);
		
		double ponto = new HeuristicaAvaliacaoPecasForaLugar().avaliaEstado(e1);
		System.out.println("" + e1 + ponto);
		
		ponto = new HeuristicaAvaliacaoPecasForaLugar().avaliaEstado(e2);
		System.out.println("" + e2 + ponto);
		
		ponto = new HeuristicaAvaliacaoPecasForaLugar().avaliaEstado(e3);
		System.out.println("" + e3 + ponto);
		
		ponto = new HeuristicaAvaliacaoPecasForaLugar().avaliaEstado(eO);
		System.out.println("" + eO + ponto);
		
		
		
	}

}
