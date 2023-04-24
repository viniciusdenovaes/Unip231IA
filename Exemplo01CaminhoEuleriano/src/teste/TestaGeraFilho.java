package teste;

import dao.InputInstance;
import entity.grafo.Caminho;
import entity.grafo.Grafo;
import entity.grafo.ParArestaVertice;
import solver.Estado;

public class TestaGeraFilho {
	
	public static void main(String[] args) {
		Grafo g = InputInstance.getInstance("files/inst01.in");
		System.out.println(g);
		Caminho c = new Caminho(g.getVertice("b"));
		Estado e = new Estado(g, c);
		System.out.println(e);
		var f = e.geraFilhos();
		for(Estado et: f) {
			et.geraFilhos();
			System.out.println();
		}
//		c.addPar(
//				new ParArestaVertice(
//						g.getAresta("a2"), 
//						g.getVertice("c")));
//		c.addPar(
//				new ParArestaVertice(
//						g.getAresta("a3"), 
//						g.getVertice("d")));
//		c.addPar(
//				new ParArestaVertice(
//						g.getAresta("a4"), 
//						g.getVertice("a")));

	}

}
