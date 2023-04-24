package entity.grafo;

public class ParArestaVertice {
	
	public Aresta a;
	public Vertice v;
	public ParArestaVertice(Aresta aA, Vertice aV) {
		this.a = aA;
		this.v = aV;
	}
	
	@Override
	public String toString() {
		String res  = " " + a.id + " " + v.id;
		return res;
	}

}
