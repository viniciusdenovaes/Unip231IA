package solver.heuristica_avaliacao;

import solver.Estado;

public class HeuristicaAvaliacaoF implements HeuristicaAvaliacao {
	
	HeuristicaAvaliacao heuristicaAvaliacao;
	HeuristicaAvaliacao avaliaNivel;

	public HeuristicaAvaliacaoF(HeuristicaAvaliacao aHeuristicaAvaliacao) {
		this.heuristicaAvaliacao = aHeuristicaAvaliacao;
		this.avaliaNivel = new HeuristicaAvaliacaoNivel();
	}

	@Override
	public double avaliaEstado(Estado estado) {
		double notaNivel = this.avaliaNivel.avaliaEstado(estado);
		double notaAvaliacao = this.heuristicaAvaliacao.avaliaEstado(estado);
		double nota = notaNivel + notaAvaliacao; 
		return nota;
	}
	
}
