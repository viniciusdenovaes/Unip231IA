package teste;

import dao.InputInstance;
import entity.grafo.Grafo;

public class TesteDao {
	
	public static void main(String[] args) {
		Grafo g = InputInstance.getInstance("files/mapa.in");
		System.out.println(g);
	}

}
