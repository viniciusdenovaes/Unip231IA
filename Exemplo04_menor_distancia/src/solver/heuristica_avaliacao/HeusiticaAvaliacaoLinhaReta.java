package solver.heuristica_avaliacao;

import entity.EspacoEstados;
import entity.Estado;
import entity.grafo.Grafo;
import entity.grafo.Vertice;

public class HeusiticaAvaliacaoLinhaReta implements HeuristicaAvaliacao {
	
	Grafo grafo;
	public HeusiticaAvaliacaoLinhaReta(Grafo grafo) {
		this.grafo = grafo;
	}

	@Override
	public double avaliaEstado(Estado estado) {
		Vertice vN = estado.getV();
		Vertice vO = EspacoEstados.estadoObjetivo.getV();
		return grafo.getDistanciaEuclidiana(vN, vO);
	}

}
