package solver.heuristica_avaliacao;

import entity.Tabuleiro;
import solver.EspacoDeEstados;
import solver.Estado;

public class HeuristicaAvaliacaoPecasForaLugar implements HeuristicaAvaliacao {

	@Override
	public double avaliaEstado(Estado estado) {
		Estado objetivo = EspacoDeEstados.OBJETIVO;
		Tabuleiro tabuleiroObjetivo = objetivo.getTabuleiro();
		int[][] pecasObjetivo = tabuleiroObjetivo.getPecas();
		
		int[][] pecasEstado = estado.getTabuleiro().getPecas();
		
		int pecasFora = 0;
		for(int i=0; i<Tabuleiro.N; i++) {
			for(int j=0; j<Tabuleiro.N; j++) {
				if(pecasEstado[i][j]==0) continue;
				if(pecasEstado[i][j] != pecasObjetivo[i][j]) {
					pecasFora++;
				}
			}
		}
		return pecasFora;
	}

}
