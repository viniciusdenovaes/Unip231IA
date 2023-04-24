package teste;

import dao.InputInstance;
import entity.Tabuleiro;
import solver.EspacoDeEstados;
import solver.Estado;

public class TesteEstadoEquals {
	
	public static void main(String[] args) {
		Tabuleiro t = InputInstance.getInstance("files/inst01.in");
		Estado e = new Estado(t);
		Tabuleiro tO = InputInstance.getInstance("files/inst_obj.in");
		Estado eO = new Estado(tO);
		
		System.out.println("estado inst01 eh objetivo?");
		System.out.println(e);
		System.out.println(e.isObjetivo());
		System.out.println("estado inst_obj eh objetivo?");
		System.out.println(eO);
		System.out.println(eO.isObjetivo());
		
		System.out.println("estado obj eh objetivo?");
		System.out.println(EspacoDeEstados.OBJETIVO);
		System.out.println(EspacoDeEstados.OBJETIVO.isObjetivo());
		
		
	}

}
