package entity.estruturas;

import java.util.Comparator;
import java.util.PriorityQueue;

import entity.Estado;
import solver.heuristica_avaliacao.HeuristicaAvaliacao;

public class FilaDePrioridade implements EstadoAbertos{
	
	HeuristicaAvaliacao heuristicaAvaliacao;
	
	PriorityQueue<Estado> fila = new PriorityQueue<>(new ComparadorEstados());

	public FilaDePrioridade(HeuristicaAvaliacao aHeuristicaAvaliacao) {
		this.heuristicaAvaliacao = aHeuristicaAvaliacao;
	}
	
	@Override
	public void push(Estado estado) {
		fila.add(estado);
	}

	@Override
	public Estado pop() {
		return fila.poll();
	}

	@Override
	public int size() {
		return fila.size();
	}
	
	class ComparadorEstados implements Comparator<Estado>{

		@Override
		public int compare(Estado e1, Estado e2) {
			double nota01 = heuristicaAvaliacao.avaliaEstado(e1);
			double nota02 = heuristicaAvaliacao.avaliaEstado(e2);
			return Double.compare(nota01, nota02);
		}
		
	}

}