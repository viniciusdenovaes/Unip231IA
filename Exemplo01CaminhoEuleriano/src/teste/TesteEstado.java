package teste;

import dao.InputInstance;
import entity.grafo.Caminho;
import entity.grafo.Grafo;
import entity.grafo.ParArestaVertice;
import entity.grafo.Vertice;
import solver.Estado;

public class TesteEstado {
	
	public static void main(String[] args) {
		Grafo g = InputInstance.getInstance("files/inst01.in");
		System.out.println(g);
		Caminho c = new Caminho(g.getVertice("b"));
		c.addPar(
				new ParArestaVertice(
						g.getAresta("a2"), 
						g.getVertice("c")));
		c.addPar(
				new ParArestaVertice(
						g.getAresta("a3"), 
						g.getVertice("d")));
		c.addPar(
				new ParArestaVertice(
						g.getAresta("a4"), 
						g.getVertice("a")));
		Estado e = new Estado(g, c);
		System.out.println(e);
		System.out.println(e.isValido());
		System.out.println(e.isObjetivo());
		c.addPar(
				new ParArestaVertice(
						g.getAresta("a1"), 
						g.getVertice("b")));
		c.addPar(
				new ParArestaVertice(
						g.getAresta("a5"), 
						g.getVertice("d")));
		e = new Estado(g, c);
		System.out.println(e);
		System.out.println(e.isValido());
		System.out.println(e.isObjetivo());
		c.addPar(
				new ParArestaVertice(
						g.getAresta("a1"), 
						g.getVertice("b")));
		e = new Estado(g, c);
		System.out.println(e);
		System.out.println(e.isValido());
		System.out.println(e.isObjetivo());
	}

}
