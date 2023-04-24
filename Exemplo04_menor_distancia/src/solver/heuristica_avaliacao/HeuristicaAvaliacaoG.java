package solver.heuristica_avaliacao;

import entity.Estado;

public class HeuristicaAvaliacaoG implements HeuristicaAvaliacao {

	@Override
	public double avaliaEstado(Estado estado) {
		double nota = estado.getCusto();
		return nota;
	}

}
