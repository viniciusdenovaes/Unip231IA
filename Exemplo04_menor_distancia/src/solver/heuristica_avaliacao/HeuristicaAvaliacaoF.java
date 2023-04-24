package solver.heuristica_avaliacao;

import entity.Estado;

public class HeuristicaAvaliacaoF implements HeuristicaAvaliacao {
	
	HeuristicaAvaliacao heuristicaAvaliacao;

	public HeuristicaAvaliacaoF(HeuristicaAvaliacao aHeuristicaAvaliacao) {
		this.heuristicaAvaliacao = aHeuristicaAvaliacao;
	}

	@Override
	public double avaliaEstado(Estado estado) {
		double notaNivel = new HeuristicaAvaliacaoG().avaliaEstado(estado);
		double notaAvaliacao = this.heuristicaAvaliacao.avaliaEstado(estado);
		double nota = notaNivel + notaAvaliacao; 
		return nota;
	}
	
}
