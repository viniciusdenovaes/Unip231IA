package entity.grafo;

public class Aresta implements Comparable<Aresta>{
	
	String id;
	Vertice v1;
	Vertice v2;
	
	public Aresta(String aId, Vertice aV1, Vertice aV2) {
		this.id = aId;
		this.v1 = aV1;
		this.v2 = aV2;
	}
	
	public Vertice getVerticeAdjacenteQueNao(Vertice v) {
		if(v.equals(v1)) {
			return v2;
		}
		else {
			return v1;
		}
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
		res += this.id + ": " + this.v1 + "---" + this.v2;
		return res;
	}
	
	

}
