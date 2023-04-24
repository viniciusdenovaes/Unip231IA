package entity.grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aresta implements Comparable<Aresta>{
	
	String id;
	Vertice v1;
	Vertice v2;
	double peso;
	
	public Aresta(Vertice aV1, Vertice aV2, double aPeso) {
		
		this.id = getIdAresta(aV1, aV2);
		this.v1 = aV1;
		this.v2 = aV2;
		this.peso = aPeso;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public Vertice getVerticeAdjacenteQueNao(Vertice v) {
		if(v.equals(v1)) {
			return v2;
		}
		else {
			return v1;
		}
	}
	
	public static String getIdAresta(Vertice v1, Vertice v2) {
		List<String> ids = new ArrayList<>();
		ids.add(v1.id);
		ids.add(v2.id);
		Collections.sort(ids);
		return ids.get(0) + "_" + ids.get(1); 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aresta other = (Aresta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Aresta o) {
		return this.id.compareTo(o.id);
	}
	
	@Override
	public String toString() {
		String res = "";
		res += this.id + ": " + this.v1 + "---" + this.v2 + " ("+this.peso+")";
		return res;
	}
	
	

}
