package teste;

import dao.InputInstance;
import entity.Tabuleiro;
import entity.estruturas.EstadoAbertos;
import entity.estruturas.FilaDePrioridade;
import solver.Estado;
import solver.heuristica_avaliacao.HeuristicaAvaliacaoPecasForaLugar;

public class TesteFilaPrioridade {
	
	public static void main(String[] args) {
		Tabuleiro t1 = InputInstance.getInstance("files/inst01.in");
		Estado e1 = new Estado(t1);
		Tabuleiro t2 = InputInstance.getInstance("files/inst02.in");
		Estado e2 = new Estado(t2);
		Tabuleiro t3 = InputInstance.getInstance("files/inst03.in");
		Estado e3 = new Estado(t3);
		Tabuleiro tO = InputInstance.getInstance("files/inst_obj.in");
		Estado eO = new Estado(tO);
		
		EstadoAbertos ea = new FilaDePrioridade(new HeuristicaAvaliacaoPecasForaLugar());
		ea.push(e1);
		ea.push(e2);
		ea.push(e3);
		ea.push(eO);
		
		while(ea.size()>0) {
			Estado e = ea.pop();
			System.out.println(e);
			System.out.println("nota: " + new HeuristicaAvaliacaoPecasForaLugar().avaliaEstado(e));
		}
		
		
	}

}
