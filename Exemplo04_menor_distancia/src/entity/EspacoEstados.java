package entity;

import java.util.Collection;
import java.util.List;

import entity.estruturas.EstadoAbertos;
import entity.grafo.Vertice;

public class EspacoEstados {
	
	public static Estado estadoInicial;
	public static Estado estadoObjetivo;
	
	 EstadoAbertos ea;
	 
	 public EspacoEstados(EstadoAbertos aEstruturaAbertos) {
		 this.ea = aEstruturaAbertos;
	}
	 
	
	 public Estado solve() {
		 
		 int iteracoes = 0;
		 this.ea.push(estadoInicial);
		 
		 while(ea.size()>0) {
			 Estado e = ea.pop();
			 System.out.println("TESTANDO ESTADO");
			 System.out.println("INTERACOES: " + iteracoes++);
			 System.out.println(e);
			 if(e.isObjetivo()) {
				 System.out.println("-------------ENCONTROU SOLUCAO----------");
				 System.out.println(e);
				 return e;
			 }
			 Collection<Estado> filhos = e.geraFilhos();
			 for(Estado filho: filhos) {
				 // System.out.println("Filho gerado: " + filho);
				 ea.push(filho);
			 }
		 }
		 
		 System.out.println("nao encontrou solucao");
		 
		 return null;
	 }
	
}




